package com.lapots.dsl.pptx.core.slideshow.layout

import com.lapots.dsl.pptx.core.slideshow.text.SlideshowText
import org.apache.poi.xslf.usermodel.XSLFSlide
import org.apache.poi.xslf.usermodel.XSLFSlideLayout

/**
 * Handles presentation title layout.
 */
class TitleLayout {
    XSLFSlide pptSlide

    def title(closure) {
        def text = new SlideshowText(index: 0, pptSlide: pptSlide)
        closure.delegate = text
        closure.setResolveStrategy = Closure.DELEGATE_ONLY
        closure()
    }

    def subtitle(closure) {
        def text = new SlideshowText(index: 1, pptSlide: pptSlide)
        closure.delegate = text
        closure.setResolveStrategy = Closure.DELEGATE_ONLY
        closure()
    }
}
