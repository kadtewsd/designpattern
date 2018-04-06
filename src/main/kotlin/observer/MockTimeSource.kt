package observer

class MockTimeSource(override var hours: Int, override var minutes: Int, override var seconds: Int) : Subject(), TimeSource {
    fun setTime() {
        notifyObservers()
    }

    fun setTime(hours: Int, minutes: Int, seconds: Int) {
        this.hours = hours
        this.minutes = minutes
        this.seconds = seconds
        this.setTime()

    }
}
