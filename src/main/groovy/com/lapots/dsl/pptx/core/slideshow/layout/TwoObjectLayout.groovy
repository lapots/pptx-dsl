package com.lapots.dsl.pptx.core.slideshow.layout

import com.lapots.dsl.pptx.core.CommonDelegateTrait
import com.lapots.dsl.pptx.core.slideshow.layout.util.LayoutSupportUtils
import com.lapots.dsl.pptx.core.slideshow.text.SlideshowText
import org.apache.poi.sl.draw.SLGraphics
import org.apache.poi.xslf.usermodel.XMLSlideShow
import org.apache.poi.xslf.usermodel.XSLFDrawing
import org.apache.poi.xslf.usermodel.XSLFGroupShape
import org.apache.poi.xslf.usermodel.XSLFShape
import org.apache.poi.xslf.usermodel.XSLFSlide

import java.awt.Graphics2D
import java.awt.Rectangle
import java.awt.geom.Rectangle2D

/**
 * Handles TWO_OBJ layout.
 *
 * | Title             |
 * |         |         |
 * | content | content |
 * |         |         |
 *
 */
class TwoObjectLayout implements CommonDelegateTrait {
    XSLFSlide pptSlide
    XMLSlideShow ppt
    int contentOffset

    def title(closure) {
        def text = new SlideshowText(index: 0, pptSlide: pptSlide)
        delegateOnly(closure, text)
    }

    def content(closure) {
        delegateOnly(closure)
    }

    def left(closure) {
        contentOffset = 2
        delegateOnly(closure)
    }

    def right(closure) {
        contentOffset = 3
        delegateOnly(closure)
    }

    def image(closure) {
        def img = closure() as String
        LayoutSupportUtils.addPicture(img, ppt, pptSlide, contentOffset)

        // investigate
        XSLFGroupShape groupShape = pptSlide.createGroup()
        groupShape.clear()
        Rectangle2D rectangle2D = new Rectangle()
        rectangle2D.setBounds(0, 0, 20, 20)

        Graphics2D graphics2D = new SLGraphics(groupShape)
        graphics2D.drawRect(0, 0, 20, 20)
        groupShape.setAnchor(rectangle2D)
    }
}
