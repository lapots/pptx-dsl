import com.lapots.dsl.pptx.PPTXRunner

def dsl = """
presentation {
    filename = 'presentation.pptx'
    slideshow {
        slide { /* blank slide */ }
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
    }
    export {
        png {
            filename { 'export_png' }
        }
        svg {
            filename { 'export_svg' }
        }
    }
}
"""

def pptxRunner = new PPTXRunner()
pptxRunner.resource_str(dsl)
