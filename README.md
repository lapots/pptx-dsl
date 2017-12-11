# pptx-dsl
DSL for presentation (pptx) generation from the code.
The idea is to provide an ability to generate presentation from the inside of some application with just data.

# TODO

* implement more layouts
* implement more image type supports
* implement text styling
* implement 2D primitives support
* implement animation support

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
                    text { 
                        data { 'Transactional Memory' }
                    }
                }
                
                subtitle {
                    text { 
                        data { 'When database meets shared memory' }
                    }
                }
            }
        }
        slide {
            titleContentLayout {
                title {
                    text {
                        data { 'Image example' }
                        format {
                            fontSize 24
                            fontItalic true
                            fontColor 'blue'
                        }
                    }
                }
                
                content {
                    image { 'L://sample.png' }
                }
            }
        }
        slide {
            twoObjectLayout {
                title {
                    text { 
                        data { 'Two images' } 
                    }
                }
                
                content {
                    left {
                        image { 'L://sample.png' }
                    }
                    // ISSUE WITH SAME OR MULTIPLE IMAGES
                    right {
                        image { 'L://sample.png' }
                    }
                }
            }
        }
    }
    
    export {
        png {
            // represents the name of seed - single element of presentation
            // every slide will be export_png-slide-0.png etc.
            exportName { 'export_png' }
        }
        svg {
            exportName { 'export_svg' }
        }
    }    
}
```
# Supported layouts

* blank
* title
* title only
* title and content
* two object layout
