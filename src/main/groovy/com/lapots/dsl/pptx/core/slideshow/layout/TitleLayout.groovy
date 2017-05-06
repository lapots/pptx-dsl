package com.lapots.dsl.pptx.core.slideshow.layout

import com.lapots.dsl.pptx.core.slideshow.text.SlideshowText
import org.apache.poi.xslf.usermodel.XSLFSlideLayout

/**
 * Handles presentation title layout.
 */
class TitleLayout {
    XSLFSlideLayout layout

    def title(closure) {

    }

    def subtitle(closure) {

    }

    def text(closure) {
        def textHandler = new SlideshowText()
        closure.delegate = textHandler
        closure.setResolverStrategy = Closure.DELEGATE_ONLY
        closure()


    }
}
