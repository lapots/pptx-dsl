# pptx-dsl
DSL for presentation (pptx) generation from the code.
The idea is to provide an ability to generate presentation from the inside of some application with just data.

# Example

Based on Apache POI and Apache Batik

```
presentation {
    // some meta information
    filename { 'presentation.pptx' }

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
    export {
        // export as png using PPTX2PNG
        png {
            // represents the name of seed - single element of presentation
            exportName { 'export_png' }
        }
        // export as svg using PPTX2SVG
        svg {
            exportName { 'export_svg' }
        }
    }    
}
```
