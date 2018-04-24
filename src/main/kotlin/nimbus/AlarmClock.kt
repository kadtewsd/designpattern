package nimbus

class AlarmClock {
    fun wakeEveryDay(listener: AlarmListener) {
        listener.wakeup()
    }
}