package com.lapots.dsl.pptx.core.slideshow.layout

import com.lapots.dsl.pptx.core.CommonDelegateTrait
import com.lapots.dsl.pptx.core.slideshow.text.SlideshowText
import org.apache.poi.xslf.usermodel.XSLFSlide

/**
 * Handles VERT_TX layout.
 */
class VerticalTextLayout implements CommonDelegateTrait {
    XSLFSlide pptSlide

    def title(closure) {
        def text = new SlideshowText(index: 0, pptSlide: pptSlide)
        delegateOnly(closure, text)
    }

    def verticalText(closure) {
        // TODO: implement
    }
}
