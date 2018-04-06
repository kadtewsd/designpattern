package observer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestClockDriver {

    @Test
    fun testTimeChange() {
        val source = MockTimeSource(3, 4, 5)
        val sink = MockTimeSink(source)
        source.registerObserver(sink)

        source.setTime()
        assertEquals(3, sink.getHours())
        assertEquals(4, sink.getMinutes())
        assertEquals(5, sink.getSeconds())

        source.setTime(7, 8,9)
        assertEquals(7, sink.getHours())
        assertEquals(8, sink.getMinutes())
        assertEquals(9, sink.getSeconds())
    }

}