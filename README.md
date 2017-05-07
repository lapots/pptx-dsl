# pptx-dsl
DSL for presentation (pptx) generation from the code.
The idea is to provide an ability to generate presentation from the inside of some application with just data.

# Example (just a goal template)

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
            filename { 'export_png' }
        }
        // export as svg using PPTX2SVG
        svg {
            filename { 'export_svg' }
        }
    }    
}
```

# Current state

```
presentation {
    filename { 'presentation.pptx' }
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
}
```