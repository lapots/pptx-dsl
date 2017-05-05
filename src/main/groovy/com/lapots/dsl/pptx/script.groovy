import com.lapots.dsl.pptx.PPTXRunner

def dsl = """
presentation {
    // some meta information
    filename { "presentation.pptx" }

    // presentation structure
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

    // ability to export
    out {
        // export as png using PPTX2PNG
        png {
            filename { 'export_png' }
        }
        // export as svg using PPTX2SVG
        svg {
            filename { 'export_svg' }
        }
    }
}
"""

def pptxRunner = new PPTXRunner()
pptxRunner.resource_str(dsl)
