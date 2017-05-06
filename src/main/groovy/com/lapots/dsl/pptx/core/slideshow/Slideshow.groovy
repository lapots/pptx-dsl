package com.lapots.dsl.pptx.core.slideshow

import org.apache.poi.xslf.usermodel.XMLSlideShow

/**
 * Handles presentation body.
 */
class Slideshow {
    @Lazy XMLSlideShow slideshow = new XMLSlideShow()
    def file

    def slide(closure) {
        def slide = new Slide(parent: slideshow)
        closure.delegate = slide
        closure.setResolveStrategy = Closure.DELEGATE_ONLY
        closure()


    }
}
