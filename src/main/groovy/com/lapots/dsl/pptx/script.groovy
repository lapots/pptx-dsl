import com.lapots.dsl.pptx.PPTXRunner
import org.apache.poi.xslf.usermodel.SlideLayout
import org.apache.poi.xslf.usermodel.XMLSlideShow
import org.apache.poi.xslf.usermodel.XSLFSlideLayout

def dsl = """
presentation {
    filename { 'presentation.pptx' }
    slideshow {
        slide {
            titleLayout {
                title {
                    text { 'Transactional Memory' }
                }

                subtitle {
                    text { 'When database meets shared memory' }
                }
            }
        }
        slide { /* blank slide */ }
    }
    export {
        png {
            exportName { 'presentation' }
        }
        svg {
            exportName { 'presentation' }
        }
    }
}
"""
/**
 * To implement layouts ( -> [Power Point name]) :
 *      +TITLE (title, subtitle) -> Title Slide
 *      +TITLE_ONLY (title) -> Title Only
 *      +BLANK () -> Blank
 *      +-TITLE_AND_CONTENT (title, content) -> Title and Content
 *      +-VERT_TX (title, vertical text) -> ?
 *      +-VERT_TITLE_AND_TX (vertical title, vertical text) -> ?
 *      +-TWO_OBJ (title, content, content) -> Two Content
 *      +-SECTION_HEADER (title, text) -> Section Header
 *      +-TWO_TX_TWO_OBJ (title, text, content, text, content) -> Comparison
 *      +-OBJ_TX (title, content, text) -> Content with Caption
 *      +-PIC_TX (title, picture, text) -> Picture with Caption
 */