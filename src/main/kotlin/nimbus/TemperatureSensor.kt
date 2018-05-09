package nimbus

import java.util.*

class TemperatureSensor : Observable(), AlarmListener {
    override fun wakeup(current:Double, time: Long) {
        this.setChanged()
        this.notifyObservers(Pair(current, time))
        this.clearChanged()
    }

    // this should be TemperatureHiLo
    fun add(observer: Observer) {
        if (observer is TemperatureHiLo) {
            this.addObserver(observer)
        }
    }
}
