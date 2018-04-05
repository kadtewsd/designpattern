package observer

class MockTimeSource : Subject(), TimeSource {

    var itsHours = 0
    var itsMinuts = 0
    var itsSecond = 0

    fun setTime(hours: Int, minutes: Int, seconds: Int) {
        itsHours = hours
        itsMinuts = minutes
        itsSecond = seconds
        notifyObservers()
    }

    override fun hours(): Int {
        return itsHours
    }

    override fun minutes(): Int {
        return itsMinuts
    }

    override fun seconds(): Int {
        return itsSecond
    }
}
