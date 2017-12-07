package com.lapots.dsl.pptx.core.slideshow.layout

import com.lapots.dsl.pptx.core.CommonDelegateTrait
import com.lapots.dsl.pptx.core.slideshow.layout.util.LayoutSupportUtils
import com.lapots.dsl.pptx.core.slideshow.text.SlideshowText
import org.apache.poi.xslf.usermodel.XMLSlideShow
import org.apache.poi.xslf.usermodel.XSLFSlide

/**
 * Handles TITLE_AND_CONTENT layout.
 *
 * |  Title  |
 * |         |
 * | content |
 * |         |
 */
class TitleContentLayout implements CommonDelegateTrait {
    XSLFSlide pptSlide
    XMLSlideShow ppt

    def title(closure) {
        def text = new SlideshowText(index: 0, pptSlide: pptSlide)
        delegateOnly(closure, text)
    }

    def content(closure) {
        // content type may vary
        delegateOnly(closure);
    }

    def image(closure) {
        def img = closure() as String
        LayoutSupportUtils.addPicture(img, ppt, pptSlide, 1)
    }

}
