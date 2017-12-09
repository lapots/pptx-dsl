import com.lapots.dsl.pptx.PPTXRunner

def dsl = """
presentation {
    filename { 'presentation.pptx' }
    slideshow {
        slide {
            twoObjectLayout {
                title {
                    text { 'Double content' }
                }
                
                content {
                    left {
                        image { 'L://groovy_project/misc/pptx-dsl/src/main/resources/sample.png' }
                    }
                    
                    right {
                        image { 'L://groovy_project/misc/pptx-dsl/src/main/resources/sample.png' }
                    }
                }
            }
        }
    }
}
"""

PPTXRunner.resource_str(dsl)

/**
 * To implement layouts ( -> [Power Point name]) :
 *      +TITLE (title, subtitle) -> Title Slide
 *      +TITLE_ONLY (title) -> Title Only
 *      +BLANK () -> Blank
 *      +TITLE_AND_CONTENT (title, content) -> Title and Content
 *      +TWO_OBJ (title, content, content) -> Two Content
 *      +-VERT_TX (title, vertical text) -> ?
 *      +-VERT_TITLE_AND_TX (vertical title, vertical text) -> ?
 *      +-SECTION_HEADER (title, text) -> Section Header
 *      +-TWO_TX_TWO_OBJ (title, text, content, text, content) -> Comparison
 *      +-OBJ_TX (title, content, text) -> Content with Caption
 *      +-PIC_TX (title, picture, text) -> Picture with Caption
 */