package com.lapots.dsl.pptx.core.slideshow

import com.lapots.dsl.pptx.core.CommonDelegateTrait
import org.apache.poi.xslf.usermodel.XMLSlideShow

/**
 * Handles presentation body.
 */
class Slideshow implements CommonDelegateTrait {
    @Lazy XMLSlideShow pptx = new XMLSlideShow()
    def slide(closure) {
        def slide = new Slide(ppt: pptx)
        delegateOnly(closure, slide)

        if (!slide.pptSlide) {
            slide.blankLayout()
        }
    }
}
