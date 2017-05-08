package com.lapots.dsl.pptx.core.slideshow.text

/**
 * Common trait for components to support text { "example" } closure
 */
trait CommonSlideshowTextTrait {
    @Lazy def textContainer

    def sys_text(closure) {
        def message = closure()
        textContainer.setText(message)
    }

    abstract def text(closure)
}
