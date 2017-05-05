package com.lapots.dsl.pptx

import com.lapots.dsl.pptx.core.DSLCore

class PPTXRunner {

    def resource_str(closure) {
        def core = new DSLCore()
        core.eval_str(closure)
    }

}
