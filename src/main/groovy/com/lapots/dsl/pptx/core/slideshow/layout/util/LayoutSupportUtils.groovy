package com.lapots.dsl.pptx.core.slideshow.layout.util

import org.apache.commons.io.FilenameUtils
import org.apache.commons.io.IOUtils
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

    // TODO: investigate issue with multiple images and indexing
    def static addPicture(img, ppt, pptSlide, index) {
        def pictureData = IOUtils.toByteArray(new FileInputStream(img))
        def pd = ppt.addPicture(pictureData as byte[], resolvePictureTypeByFile(img))
        def pic = pptSlide.createPicture(pd)

        // TODO: investigate possible issue with indexing due to clearing placeholder
        def anchor = clearPlaceholderWithAnchor(index, pptSlide)
        pic.setAnchor(anchor)
    }

}
