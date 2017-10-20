# Read Me

## Output Generation

### HTML

The `.html` file is generated out of the `.adoc` file using the stylesheet `themes/validation.css` using the following command :

> `asciidoctor -a stylesheet=themes/validation.css Schema.adoc`

The `validation.css` stylesheet imports the [original `asciidoctor-compact.css` stylesheet](https://github.com/asciidoctor/brackets-asciidoc-preview/blob/master/themes/asciidoctor-compact.css).  

It adds styles to handle the rendering of schemas and instances.
