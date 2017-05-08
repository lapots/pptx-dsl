package com.lapots.poi.pptx.svg;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import com.lapots.poi.pptx.org.apache.poi.xslf.usermodel.WMFImageRender;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import com.lapots.poi.pptx.org.apache.poi.xslf.usermodel.XSLFRenderingHint;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class PPTX2SVGConverter {
    private XMLSlideShow source;
    private Dimension pgsize;
    private String sourceName;
    private int index = 0;

    public void setSource(XMLSlideShow source) {
        this.source = source;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public void convert() {
        List<XSLFSlide> slides = source.getSlides();
        pgsize = source.getPageSize();

        slides.stream()
                .map(this::convertSlide)
                .forEach(this::writeSlide);
    }

    private NamedDOMSource convertSlide(XSLFSlide slide) {
        DOMImplementation domImpl = SVGDOMImplementation.getDOMImplementation();
        Document doc = domImpl.createDocument("http://www.w3.org/2000/svg", "svg", null);
        //Use Batik SVG Graphics2D driver
        SVGGraphics2D graphics = new SVGGraphics2D(doc);
        graphics.setRenderingHint(XSLFRenderingHint.IMAGE_RENDERER, new WMFImageRender());
        graphics.setSVGCanvasSize(pgsize);

        String title = sourceName + "-slide-" + index + ".svg";
        index++;

        // draw stuff. All the heavy-lifting happens here
        slide.draw(graphics);
        return new NamedDOMSource(title, new DOMSource(graphics.getRoot()));
    }

    private void writeSlide(NamedDOMSource source) {
        try (OutputStreamWriter out =
                new OutputStreamWriter(new FileOutputStream(source.name), "UTF-8")) {
            StreamResult streamResult = new StreamResult(out);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer serializer = tf.newTransformer();
            serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
            serializer.transform(source.domSource, streamResult);
        } catch (Exception exc) {
            System.out.println("Failed to write to filesystem => " + exc);
        }
    }

    private class NamedDOMSource {
        private String name;
        private DOMSource domSource;

        public NamedDOMSource(String name, DOMSource domSource) {
            this.name = name;
            this.domSource = domSource;
        }
    }
}
