package com.lapots.dsl.pptx

import com.lapots.dsl.pptx.core.DSLCore

class PPTXRunner {

    def static resource_str(closure) {
        def core = new DSLCore()
        core.eval_str(closure)
    }

}
