package extensionobject

import org.jdom2.Element

interface XMLPartExtension : PartExtension {

    fun getXMLElement(): Element
}