package com.lapots.dsl.pptx.core

/**
 * Trait for self delegation.
 */
trait CommonDelegateTrait {

    def delegateOnly(closure) {
        closure.delegate = this
        sys_delegateOny(closure)
    }

    def delegateOnly(closure, obj) {
        closure.delegate = obj
        sys_delegateOny(closure)
    }

    private def sys_delegateOny(closure) {
        closure.setResolveStrategy = Closure.DELEGATE_ONLY
        closure()
    }
}
