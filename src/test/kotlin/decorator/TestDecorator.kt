package decorator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestModemDecorator {
    @Test
    fun testLoudDialog() {
        val modem = HaynesModem()
        // Proxy と違い外から移譲クラスを渡す。
        val long = LongDialModem(modem)
        long.dial("55558888")
        assertEquals("55558888", long.phoneNumber)
        assertEquals(11, long.volume)
    }
}