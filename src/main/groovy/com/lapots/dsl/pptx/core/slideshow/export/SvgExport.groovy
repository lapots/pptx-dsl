package com.lapots.dsl.pptx.core.slideshow.export

import com.lapots.dsl.pptx.core.CommonDelegateTrait
import com.lapots.poi.pptx.svg.PPTX2SVGConverter

class SvgExport implements CommonDelegateTrait, IExport {
    def slideshow
    def seed

    def exportName(closure) {
        seed = closure()
    }

    @Override
    def export() {
        PPTX2SVGConverter converter = new PPTX2SVGConverter();
        converter.setSource(slideshow);
        converter.setSourceName(seed)

        converter.convert();
    }
}
