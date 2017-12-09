package com.lapots.dsl.pptx.core.slideshow

import com.lapots.dsl.pptx.core.CommonDelegateTrait
import com.lapots.dsl.pptx.core.slideshow.layout.TitleContentLayout
import com.lapots.dsl.pptx.core.slideshow.layout.TitleLayout
import com.lapots.dsl.pptx.core.slideshow.layout.TwoObjectLayout
import org.apache.poi.xslf.usermodel.SlideLayout
import org.apache.poi.xslf.usermodel.XMLSlideShow
import org.apache.poi.xslf.usermodel.XSLFSlide
import org.apache.poi.xslf.usermodel.XSLFSlideMaster

/**
 * Presentation slide.
 */
class Slide implements CommonDelegateTrait {
    XMLSlideShow ppt
    XSLFSlide pptSlide

    // 0 master by default
    @Lazy XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0)

    /**
     * Handles TITLE layout
     * @param closure
     * @return
     */
    def titleLayout(closure) {
        pptSlide = ppt.createSlide(defaultMaster.getLayout(SlideLayout.TITLE))
        def titleLayout = new TitleLayout(pptSlide: pptSlide)
        delegateOnly(closure, titleLayout)
    }

    /**
     * Handles BLANK layout
     * @return none
     */
    def blankLayout() {
        pptSlide = ppt.createSlide()
    }

    /**
     * Handles TITLE_AND_CONTENT layout
     * @param closure
     * @return
     */
    def titleContentLayout(closure) {
        pptSlide = ppt.createSlide(defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT))
        def titleContentLayout = new TitleContentLayout(pptSlide: pptSlide, ppt: ppt)
        delegateOnly(closure, titleContentLayout)
    }

    /**
     * Handles TWO_OBJECT layout
     *
     * @param closure
     * @return
     */
    def twoObjectLayout(closure) {
        pptSlide = ppt.createSlide(defaultMaster.getLayout(SlideLayout.TWO_OBJ))
        def twoObjectLayout = new TwoObjectLayout(pptSlide: pptSlide, ppt: ppt)
        delegateOnly(closure, twoObjectLayout)
    }
}
