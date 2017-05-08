package com.lapots.dsl.pptx.core.slideshow.export

import com.lapots.dsl.pptx.core.CommonDelegateTrait

class PngExport implements CommonDelegateTrait, IExport {
    def slideshow

    def exportName(closure) {
    }

    @Override
    def export() {
        // do something
    }
}
