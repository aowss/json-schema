# Read Me

## Output Generation

### HTML

The `.html` file is generated out of the `.adoc` file using the stylesheet `themes/asciidoctor-compact.css` using the following command :

> `asciidoctor -a stylesheet=themes/asciidoctor-compact.css Schema.adoc`

The only modification to the [original `asciidoctor-compact.css` stylesheet](https://github.com/asciidoctor/brackets-asciidoc-preview/blob/master/themes/asciidoctor-compact.css) is the addition of styles to handle the rendering of schemas and instances.
