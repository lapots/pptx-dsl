package com.lapots.dsl.pptx.core.slideshow.text

import org.apache.poi.xslf.usermodel.XSLFSlide
import org.apache.poi.xslf.usermodel.XSLFTextShape

/**
 * Handles text in the presentation.
 */
class SlideshowText implements CommonSlideshowTextTrait {
    def index
    XSLFSlide pptSlide

    // it would be good to method inherit there like
    /*
        def text(closure) : sys_text(closure) {
            textContainer = pptSlide.getPlaceholder(index) as XLSFTextShape
        }

        or

        def text(closure) :
            sys_text(closure, pptSlide.getPlaceholder(index) as XLSFTextShape) {}
     */
    @Override
    def text(closure) {
        textContainer = pptSlide.getPlaceholder(index) as XSLFTextShape
        sys_text(closure)
    }

}
