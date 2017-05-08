package com.lapots.poi.pptx.png;

import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PPTX2PNGConverter {
    private XMLSlideShow source;
    private String sourceName;
    private Dimension pgsize;
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

    private BufferedImage convertSlide(XSLFSlide slide) {
        BufferedImage img = new BufferedImage((int) pgsize.getWidth(), (int) pgsize.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = img.createGraphics();
        DrawFactory.getInstance(graphics).fixFonts(graphics);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);

        slide.draw(graphics);
        return img;
    }

    private void writeSlide(BufferedImage img) {
        String title = sourceName + "-slide-" + index + ".png";
        index++;

        File outfile = new File(title);
        try {
            ImageIO.write(img, "png", outfile);
        } catch (IOException e) {
            System.out.println("Failed to write image => " + e);
        }

        img.flush();
    }
}
