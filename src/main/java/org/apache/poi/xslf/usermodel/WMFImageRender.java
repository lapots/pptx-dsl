package org.apache.poi.xslf.usermodel;

import org.apache.batik.transcoder.wmf.tosvg.WMFPainter;
import org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore;
import org.apache.poi.openxml4j.opc.PackagePart;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Image renderer with support for .wmf images
 *
 * @author Yegor Kozlov
 */
public class WMFImageRender extends XSLFImageRenderer {

    /**
     * Use Apache Batik to render WMF,
     * delegate all other types of images to the javax.imageio framework
     */
    @Override
    public boolean drawImage(Graphics2D graphics, XSLFPictureData data,
                             Rectangle2D anchor) {
        try {
            // see what type of image we are
            PackagePart part = data.getPackagePart();
            String contentType = part.getContentType();
            if (contentType.equals("image/x-wmf")) {
                WMFRecordStore currentStore = new WMFRecordStore();
                currentStore.read(new DataInputStream(part.getInputStream()));
                int wmfwidth = currentStore.getWidthPixels();
                float conv = (float) anchor.getWidth() / wmfwidth;

                // Build a painter for the RecordStore
                WMFPainter painter = new WMFPainter(currentStore,
                        (int) anchor.getX(), (int) anchor.getY(), conv);
                painter.paint(graphics);
            } else {
                BufferedImage img = ImageIO.read(data.getPackagePart().getInputStream());
                graphics.drawImage(img,
                        (int) anchor.getX(), (int) anchor.getY(),
                        (int) anchor.getWidth(), (int) anchor.getHeight(), null);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Convert data form the supplied package part into a BufferedImage.
     * This method is used to create texture paint.
     */
    @Override
    public BufferedImage readImage(PackagePart packagePart) throws IOException {
        String contentType = packagePart.getContentType();
        if (contentType.equals("image/x-wmf")) {
            try {
                WMFRecordStore currentStore = new WMFRecordStore();
                currentStore.read(new DataInputStream(packagePart.getInputStream()));
                int wmfwidth = currentStore.getWidthPixels();
                int wmfheight = currentStore.getHeightPixels();

                BufferedImage img = new BufferedImage(wmfwidth, wmfheight, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = img.createGraphics();

                // Build a painter for the RecordStore
                WMFPainter painter = new WMFPainter(currentStore, 0, 0, 1.0f);
                painter.paint(graphics);

                return img;
            } catch (IOException e) {
                return null;
            }
        } else {
            return ImageIO.read(packagePart.getInputStream());
        }
    }
}
