package com.lapots.dsl.pptx.core

/**
 * Core class that evaluates dsl.
 */
class DSLCore {
    def filename

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
    }

    def slideshow(closure) {}

    def out(closure) {}

    def filename(closure) {
        filename = closure()
    }
}
