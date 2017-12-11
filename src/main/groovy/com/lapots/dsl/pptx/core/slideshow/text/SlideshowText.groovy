package com.lapots.dsl.pptx.core.slideshow.text

import com.lapots.dsl.pptx.core.CommonDelegateTrait
import org.apache.poi.xslf.usermodel.XSLFShape
import org.apache.poi.xslf.usermodel.XSLFSlide
import org.apache.poi.xslf.usermodel.XSLFTextRun
import org.apache.poi.xslf.usermodel.XSLFTextShape

import java.awt.Color

/**
 * Handles text in the presentation.
 */
class SlideshowText implements CommonDelegateTrait {
    int index
    XSLFTextRun textRun
    XSLFSlide pptSlide

    def text(closure) {
        def textShape = pptSlide.getPlaceholder(index) as XSLFTextShape
        textShape.clearText()
        textRun = textShape
                .addNewTextParagraph()
                .addNewTextRun()

        delegateOnly(closure)
    }

    def data(closure) {
        def text = closure() as String
        textRun.setText(text)
    }

    def format(closure) {
        delegateOnly(closure, new TextFormat())
    }

    private class TextFormat {
        def fontSize(value) {
            textRun.setFontSize(value)
        }

        def fontItalic(flag) {
            textRun.setItalic(flag)
        }

        def fontColor(color) {
            textRun.setFontColor(resolveColor(color))
        }

        // TODO: move to utils
        private def resolveColor(color) {
            switch (color) {
                case "blue": return Color.blue
            }
        }
    }
}
