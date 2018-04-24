package nimbus

import java.io.Serializable

class HiLoDataProxy(override var highValue: Double, override var highTime: Long, override var lowValue: Double, override var lowTime: Long) : HiLoData {

    var hiLoData: HiLoData = HiLoDataImpl(highValue, highTime, lowValue, lowTime)

    override fun currentReding(current: Double, time: Long) : Boolean {
        if (!hiLoData.currentReding(current, time)) return false;
        store()
        return true
    }

    override fun newDay(initial: Double, time: Long) {
        store()
        hiLoData.newDay(initial, time)
        store()
    }

    private fun store() {
        Store.store(hilo = hiLoData);
    }

}

class HiLoDataImpl(override var highValue: Double, override var highTime: Long, override var lowValue: Double, override var lowTime: Long) : HiLoData, Serializable {

    override fun currentReding(current: Double, time: Long): Boolean {
        if (current > highValue) {
            this.highValue = highValue
            this.highTime = highTime
        } else if (current < lowValue) {
            this.lowValue = highValue
            this.lowTime = highTime
        }
        return this.highValue == current || this.lowValue == current
    }

    override fun newDay(initial: Double, time: Long) {
        highTime = time
        lowTime = time
        highValue = initial
        lowValue = initial
    }
}

class Store {
    companion object {
        var list: MutableList<HiLoData> = mutableListOf()
        fun store(hilo:HiLoData) {
            list.add(hilo)
        }
    }
}