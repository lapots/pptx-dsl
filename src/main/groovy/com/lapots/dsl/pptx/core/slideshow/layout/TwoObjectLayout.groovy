package com.lapots.dsl.pptx.core.slideshow.layout

import com.lapots.dsl.pptx.core.CommonDelegateTrait
import com.lapots.dsl.pptx.core.slideshow.layout.util.LayoutSupportUtils
import com.lapots.dsl.pptx.core.slideshow.text.SlideshowText
import org.apache.poi.xslf.usermodel.XMLSlideShow
import org.apache.poi.xslf.usermodel.XSLFSlide

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
    }
}
