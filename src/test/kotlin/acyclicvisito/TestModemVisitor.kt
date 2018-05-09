package acyclicvisito

import acyclicvisitor.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestModemVisitor {

    @BeforeEach
    fun setUp() {
         configurator = UnixModemConfigurator()

    }

    lateinit var configurator: UnixModemConfigurator

    val haynes = HaynesModem()
    val zoom = ZoomModem()
    val ernie = ErnieModem()

    @Test
    fun testHaynes() {
        haynes.acceptAcyclic(configurator)
        assertEquals("connectionString", haynes.configurationString)
    }

    @Test
    fun testErnie() {
        zoom.acceptAcyclic(configurator)
        assertEquals(90, zoom.configurationValue)
    }

    @Test
    fun testZoom() {
        ernie.acceptAcyclic(configurator)
        assertEquals("internal Pattern", ernie.inernalPattern)
    }

    @Test
    fun testAcyclicHaynes() {
        haynes.acceptAcyclic(configurator)
        assertEquals("connectionString", haynes.configurationString)
    }

    @Test
    fun testAcyclicZoom() {
        zoom.accept(configurator)
        assertEquals(90, zoom.configurationValue)
    }

    @Test
    fun testAcyclicErnie() {
        ernie.accept(configurator)
        assertEquals("internal Pattern", ernie.inernalPattern)
    }
}