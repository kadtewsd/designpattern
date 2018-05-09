package nimbus

class AlarmClock {
    fun wakeEveryDay(listener: AlarmListener, temperature:Double, time:Long) {
        listener.wakeup(temperature, time)
    }
}