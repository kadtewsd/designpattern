package extensionobject

import org.jdom2.Element


class XMLPiecePartExtension(val p: PiecePart) : XMLPartExtension {
    override fun getXMLElement(): Element {
        val e = Element("PiecePart")
        e.addContent(Element("PartNumber").setText(p.partNumber))
        e.addContent(Element("Description").setText(p.description))
        e.addContent(Element("Cost").setText(p.cost.toString()))
        return e
    }
}