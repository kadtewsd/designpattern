package nimbus

import java.util.*

class TemperatureHiLo(val hiLoData: HiLoData) : Observer {

    override fun update(o: Observable?, arg: Any?) {
        val current = arg as Pair<Double, Long>
        this.hiLoData.currentReding(current.first, current.second)
    }

    fun newDay(value: Double, time: Long) {
        hiLoData.newDay(value, time)
    }
}