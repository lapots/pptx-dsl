package com.lapots.dsl.pptx.core

import com.lapots.dsl.pptx.core.slideshow.Slideshow
import com.lapots.dsl.pptx.core.slideshow.export.ExportFacade

/**
 * Core class that evaluates dsl.
 */
class DSLCore implements CommonDelegateTrait {
    def slideshow
    def filename

    def exportCallback = []

    def eval_str(closure) {
        def shellClosure = new GroovyShell().evaluate("{ -> $closure }")
        delegateOnly(shellClosure)
    }

    // just entry point
    def presentation(closure) {
        delegateOnly(closure)

        // save
        def fos = new FileOutputStream(filename)
        slideshow.pptx.write(fos)
        fos.close()

        // do export after everything was initialized
        exportCallback.each {
            def exportFacade = new ExportFacade(slideshowToExport: slideshow.pptx)
            delegateOnly(it, exportFacade) // setting closure there causes ConcurrentModificationException lol

            exportFacade.doExport()
        }
    }

    def slideshow(closure) {
        slideshow = new Slideshow()

        delegateOnly(closure, slideshow)
    }

    def export(closure) {
        exportCallback << closure
    }

    def filename(closure) {
        filename = closure()
    }
}
