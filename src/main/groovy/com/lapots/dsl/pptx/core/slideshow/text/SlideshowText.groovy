package com.lapots.dsl.pptx.core.slideshow.text

import org.apache.poi.xslf.usermodel.XSLFSlide
import org.apache.poi.xslf.usermodel.XSLFTextShape

/**
 * Handles text in the presentation.
 */
class SlideshowText {
    def index
    XSLFSlide pptSlide

    // cannot be instantiated before index & pptSlide
    @Lazy XSLFTextShape textContainer = pptSlide.getPlaceholder(index)
    def text(closure) {
        def message = closure()
        textContainer.setText(message)
    }

}
