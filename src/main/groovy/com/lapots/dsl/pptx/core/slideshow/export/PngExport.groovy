package com.lapots.dsl.pptx.core.slideshow.export

import com.lapots.dsl.pptx.core.CommonDelegateTrait
import com.lapots.poi.pptx.png.PPTX2PNGConverter
import groovy.transform.CompileStatic
import org.apache.poi.xslf.usermodel.XMLSlideShow

class PngExport implements CommonDelegateTrait, IExport {
    XMLSlideShow slideshow
    String seed

    def exportName(closure) {
        seed = closure()
    }

    // my rule for @compilestatic is to use it when I operate
    // with Java only and don't need Groovy features
    @Override
    @CompileStatic
    def export() {
        PPTX2PNGConverter converter = new PPTX2PNGConverter()
        converter.setSource(slideshow)
        converter.setSourceName(seed)
        converter.convert()
    }
}
