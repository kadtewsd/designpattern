package nimbus

import java.util.*

class TemperatureHiLo(val alarmClock: AlarmClock, val hiLoData: HiLoData) : Observer {
    override fun update(o: Observable?, arg: Any?) {

    }

    lateinit var  observable: TemperatureSensor
    fun addObserver(t:TemperatureSensor) {
        t.addObserver(this)
    }

    fun newDay(value: Double, time: Long) {
        hiLoData.newDay(value, time)
    }
}