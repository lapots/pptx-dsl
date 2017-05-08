package com.lapots.dsl.pptx.core.slideshow.export

import com.lapots.dsl.pptx.core.CommonDelegateTrait

/**
 * Facade over exports.
 */
class ExportFacade implements CommonDelegateTrait {
    def slideshowToExport
    def exportChain = []

    def png(closure) {
        def pngExport = new PngExport(slideshow: slideshowToExport)
        delegateOnly(closure, pngExport)

        exportChain << pngExport
    }

    def svg(closure) {
        def svgExport = new SvgExport(slideshow: slideshowToExport)
        delegateOnly(closure, svgExport)

        exportChain << svgExport
    }

    def doExport() {
        exportChain*.export()
    }
}
