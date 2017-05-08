package org.apache.poi.xslf.usermodel;

import org.apache.poi.util.Internal;

import java.awt.RenderingHints;

/**
 *
 * @author Yegor Kozlov
 */
public class XSLFRenderingHint extends RenderingHints.Key {

    public XSLFRenderingHint(int i){
        super(i);
    }

    @Override
    public boolean isCompatibleValue(Object val) {
        return true;
    }

    public static final XSLFRenderingHint GSAVE = new XSLFRenderingHint(1);
    public static final XSLFRenderingHint GRESTORE = new XSLFRenderingHint(2);

    /**
     * Use a custom image rendener
     *
     * @see XSLFImageRenderer
     */
    public static final XSLFRenderingHint IMAGE_RENDERER = new XSLFRenderingHint(3);

    /**
     *  how to render text:
     *
     *  {@link #TEXT_AS_CHARACTERS} (default) means to draw via
     *   {@link java.awt.Graphics2D#drawString(java.text.AttributedCharacterIterator, float, float)}.
     *   This mode draws text as characters. Use it if the target graphics writes the actual
     *   character codes instead of glyph outlines (PDFGraphics2D, SVGGraphics2D, etc.)
     *
     *   {@link #TEXT_AS_SHAPES} means to render via
     *   {@link java.awt.font.TextLayout#draw(java.awt.Graphics2D, float, float)}.
     *   This mode draws glyphs as shapes and provides some advanced capabilities such as
     *   justification and font substitution. Use it if the target graphics is an image.
     *
     */
    public static final XSLFRenderingHint TEXT_RENDERING_MODE = new XSLFRenderingHint(4);

    /**
     * draw text via {@link java.awt.Graphics2D#drawString(java.text.AttributedCharacterIterator, float, float)}
     */
    public static final int TEXT_AS_CHARACTERS = 1;

    /**
     * draw text via {@link java.awt.font.TextLayout#draw(java.awt.Graphics2D, float, float)}
     */
    public static final int TEXT_AS_SHAPES = 2;

    @Internal
    static final XSLFRenderingHint GROUP_TRANSFORM = new XSLFRenderingHint(5);

    /**
     * Use this object to resolve unknown / missing fonts when rendering slides
     */
    public static final XSLFRenderingHint FONT_HANDLER = new XSLFRenderingHint(6);

}