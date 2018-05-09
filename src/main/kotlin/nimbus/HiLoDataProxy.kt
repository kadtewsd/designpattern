package nimbus

import java.io.Serializable

class HiLoDataProxy : HiLoData {
    override val highValue: Double
        get() = hiLoData.highValue
    override val highTime: Long
        get() = hiLoData.highTime
    override val lowValue: Double
        get() = hiLoData.lowValue
    override val lowTime: Long
        get() = hiLoData.lowTime

    var hiLoData: HiLoData = HiLoDataImpl()

    override fun currentReding(temperature: Double, time: Long) : Boolean {
        if (!hiLoData.currentReding(temperature, time)) return false;
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

class HiLoDataImpl : HiLoData, Serializable {
    override val highValue: Double
        get() = this._highValue
    override val highTime: Long
        get() = this._highTime
    override val lowValue: Double
        get() = this._lowValue
    override val lowTime: Long
        get() = this._lowTime

    private var _highValue: Double = -1.0
    private var _highTime: Long = -1L
    private var _lowValue: Double = -1.0
    private var _lowTime: Long = -1L

    override fun currentReding(temperature: Double, time: Long): Boolean {
        if (temperature > highValue) {
            this._highValue = temperature
            this._highTime = time
        } else if (temperature < _lowValue) {
            this._lowValue = temperature
            this._lowTime = time
        }
        return this._highValue == temperature || this._lowValue == temperature
    }

    override fun newDay(initial: Double, time: Long) {
        _highTime = time
        _lowTime = time
        _highValue = initial
        _lowValue = initial
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