package com.lapots.dsl.pptx.core.slideshow

import org.apache.poi.xslf.usermodel.XMLSlideShow

/**
 * Handles presentation body.
 */
class Slideshow {
    @Lazy XMLSlideShow pptx = new XMLSlideShow()
    def slide(closure) {
        def slide = new Slide(ppt: pptx)
        closure.delegate = slide
        closure.setResolveStrategy = Closure.DELEGATE_ONLY
        closure()

        if (!slide.pptSlide) {
            slide.blankLayout()
        }
    }
}
