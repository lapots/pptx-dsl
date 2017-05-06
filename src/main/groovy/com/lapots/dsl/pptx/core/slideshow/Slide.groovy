package com.lapots.dsl.pptx.core.slideshow

import com.lapots.dsl.pptx.core.slideshow.layout.TitleLayout
import org.apache.poi.xslf.usermodel.SlideLayout
import org.apache.poi.xslf.usermodel.XSLFSlide
import org.apache.poi.xslf.usermodel.XSLFSlideMaster

/**
 * Presentation slide.
 */
class Slide {
    XSLFSlideMaster defaultMaster
    @Lazy XSLFSlide slide = new XSLFSlide()

    def titleLayout(closure) {
        def layout = new TitleLayout(layout: defaultMaster.getLayout(SlideLayout.TITLE))
        closure.delegate = layout
        closure.setResolveStrategy = Closure.DELEGATE_ONLY
        closure()
    }
}
