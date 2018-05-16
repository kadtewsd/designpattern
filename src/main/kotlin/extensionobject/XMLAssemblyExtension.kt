package extensionobject

import org.jdom2.Element


class XMLAssemblyExtension(val p: Assembly) : XMLPartExtension {
    override fun getXMLElement(): Element {
        val e = Element("Assembly")
        e.addContent(Element("PartNumber").setText(p.partNumber))
        e.addContent(Element("Description").setText(p.description))
        val part = Element("Parts")
        val itr = p.getParts()
        while (itr.hasNext()) {
            part.addContent(
                    (itr.next().getExtension("XML") as XMLPartExtension)
                            .getXMLElement())
        }
        return e
    }
}