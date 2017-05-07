package com.lapots.dsl.pptx.core.slideshow

import com.lapots.dsl.pptx.core.slideshow.layout.TitleLayout
import org.apache.poi.xslf.usermodel.SlideLayout
import org.apache.poi.xslf.usermodel.XMLSlideShow
import org.apache.poi.xslf.usermodel.XSLFSlide
import org.apache.poi.xslf.usermodel.XSLFSlideMaster

/**
 * Presentation slide.
 */
class Slide {
    XMLSlideShow ppt
    XSLFSlide pptSlide

    // 0 master by default
    @Lazy XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0)

    def titleLayout(closure) {
        pptSlide = ppt.createSlide(defaultMaster.getLayout(SlideLayout.TITLE))
        def titleLayout = new TitleLayout(pptSlide: pptSlide)
        closure.delegate = titleLayout
        closure.setResolveStrategy = Closure.DELEGATE_ONLY
        closure()
    }

    def blankLayout() {
        pptSlide = ppt.createSlide()
    }
}
