package com.lapots.dsl.pptx.core.slideshow.layout

import com.lapots.dsl.pptx.core.CommonDelegateTrait
import com.lapots.dsl.pptx.core.slideshow.text.SlideshowText
import org.apache.poi.xslf.usermodel.XSLFSlide

/**
 * Handles TWO_TX_TWO_OBJ layout.
 */
class TwoTextTwoObjectLayout implements CommonDelegateTrait {
    XSLFSlide pptSlide
    int textIndex = 1
    int contentIndex = 1

    def title(closure) {
        def text = new SlideshowText(index: 0, pptSlide: pptSlide)
        delegateOnly(closure, text)
    }

    def text(closure) {
        // TODO: implement
    }

    def content(closure) {
        // TODO: implement
    }
}
