package observer

class MockTimeSink(val timeSource: TimeSource) : Observer {

    var itsHours = 0
    var itsMinuts = 0
    var itsSecond = 0
    override fun update() {
        itsHours = timeSource.hours()
        itsMinuts = timeSource.minutes()
        itsSecond = timeSource.seconds()
    }
    fun getHours(): Int {
        return itsHours
    }

    fun getMinutes(): Int {
        return itsMinuts
    }

    fun getSeconds(): Int {
        return itsSecond
    }
}