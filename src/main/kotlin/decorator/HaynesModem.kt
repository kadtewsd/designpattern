package decorator

class HaynesModem : Modem {

    override val phoneNumber: String
        get() = pno

    override var volume: Int
        get() = this._volume
        set(value) {this._volume = value}

    private var pno = ""
    private var _volume = -19

    override fun adjust(volume: Int) {
        this.volume = volume
    }

    override fun dial(pno: String) {
        this.pno = pno
    }
}