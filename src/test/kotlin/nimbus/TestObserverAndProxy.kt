package nimbus

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestObserverAndProxy {

    @Test
    fun testNimbus() {

        val tHilo = TemperatureHiLo(HiLoDataProxy())
        assertEquals(tHilo.hiLoData.highTime, -1L)
        assertEquals(tHilo.hiLoData.highValue, -1.0)
        assertEquals(tHilo.hiLoData.lowTime, -1L)
        assertEquals(tHilo.hiLoData.lowValue, -1.0)

        tHilo.newDay(20.0, 50L)
        assertEquals(tHilo.hiLoData.highTime, 50L)
        assertEquals(tHilo.hiLoData.highValue, 20.0)
        assertEquals(tHilo.hiLoData.lowTime, 50L)
        assertEquals(tHilo.hiLoData.lowValue, 20.0)

        val temp = TemperatureSensor()
        temp.add(tHilo)

        val alarmClock = AlarmClock()
        alarmClock.wakeEveryDay(temp, 2.0, 30L)

        assertEquals(tHilo.hiLoData.highTime, 50L)
        assertEquals(tHilo.hiLoData.highValue, 20.0)
        assertEquals(tHilo.hiLoData.lowTime, 30L)
        assertEquals(tHilo.hiLoData.lowValue, 2.0)
    }
}