import com.lapots.dsl.pptx.PPTXRunner

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

def pptxRunner = new PPTXRunner()
pptxRunner.resource_str(dsl)
