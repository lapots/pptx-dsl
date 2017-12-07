package com.lapots.dsl.pptx.core.slideshow.layout.util

import org.apache.commons.io.FilenameUtils
import org.apache.poi.sl.usermodel.PictureData
import org.apache.poi.xslf.usermodel.XSLFShape

import java.awt.geom.Rectangle2D

class LayoutSupportUtils {

    def static clearPlaceholderWithAnchor(index, slide) {
        XSLFShape pic = slide.getShapes()[index]
        Rectangle2D anchor = pic.getAnchor()
        slide.removeShape(pic)

        anchor
    }

    def static resolvePictureTypeByFile(file) {
        def ext = FilenameUtils.getExtension(file)
        switch (ext) {
            case 'png':
                return PictureData.PictureType.PNG
            case 'bmp':
                return PictureData.PictureType.BMP
            default:
                return null // not supported
        }
    }

}
