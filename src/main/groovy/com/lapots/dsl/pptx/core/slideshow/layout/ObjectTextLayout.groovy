package com.lapots.dsl.pptx.core.slideshow.layout

import com.lapots.dsl.pptx.core.CommonDelegateTrait
import com.lapots.dsl.pptx.core.slideshow.text.SlideshowText
import org.apache.poi.xslf.usermodel.XSLFSlide

/**
 * Implements OBJ_TX layout
 *
 *      | Title |
 *      | text  |         |
 *      |       | content |
 *      |       |         |
 */
class ObjectTextLayout implements CommonDelegateTrait {
    XSLFSlide pptSlide

    def title(closure) {
        def text = new SlideshowText(index: 0, pptSlide: pptSlide)
        delegateOnly(closure, text)
    }

    def content(closure) {
        // TODO: implement
    }

    def text(closure) {
        // TODO: implement
    }
}
