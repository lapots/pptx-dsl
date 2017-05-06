package com.lapots.dsl.pptx.core

import com.lapots.dsl.pptx.core.slideshow.Slideshow

/**
 * Core class that evaluates dsl.
 */
class DSLCore {
    def filename
    def slideshow

    def eval_str(closure) {
        def shellClosure = new GroovyShell().evaluate("{ -> $closure }")
        shellClosure.delegate = this
        shellClosure()
    }

    // just entry point
    def presentation(closure) {
        closure.delegate = this
        closure.setResovleStrategy = Closure.DELEGATE_ONLY
        closure()

        println "Filename: $filename"

        // ready to output
        slideshow.file = new FileInputStream(filename)
    }

    def slideshow(closure) {
        slideshow = new Slideshow()

        closure.delegate = slideshow
        closure.setResolveStrategy = Closure.DELEGATE_ONLY
        closure()
    }

    def export(closure) {}

    def filename(closure) {
        filename = closure()
    }
}
