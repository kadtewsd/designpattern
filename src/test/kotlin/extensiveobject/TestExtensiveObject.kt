package extensiveobject

import extensionobject.Assembly
import extensionobject.CSVPartExtension
import extensionobject.PiecePart
import extensionobject.XMLPartExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestExtensiveObject {
    lateinit var a: Assembly
    lateinit var p1: PiecePart
    lateinit var p2: PiecePart

    @BeforeEach
    fun setUp() {
        a = Assembly("32432", "MyAssembly")
        p1 = PiecePart("77734", "Hell", 666.0)
        p2 = PiecePart("42423", "MyPart", 324.1)
    }

    @Test
    fun testAssemblyWithPartsXml() {
        with(a) {
            add(p1)
            add(p2)
        }
        val xml = (a.getExtension("XML") as XMLPartExtension).getXMLElement()
        assertEquals("Assembly", xml.name)
        assertEquals("32432", xml.getChild("PartNumber").textTrim)
    }

    @Test
    fun testAssemblyWithPartsCsv() {
        with(a) {
            add(p1)
            add(p2)
        }
        val csv = (a.getExtension("CSV") as CSVPartExtension).getCSV()
        assertEquals("Assembly,32432,MyAssembly," +
                "{PiecePart,77734,Hell,666.0}," +
                "{PiecePart,42423,MyPart,324.1}", csv)
    }
}