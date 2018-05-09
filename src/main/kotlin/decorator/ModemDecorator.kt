package decorator

/**
 * 親クラスとして移譲に関するコードを全てかき切る。
 */
abstract class ModemDecorator(val m: Modem) : Modem {
    override val phoneNumber: String
        get() = m.phoneNumber
    override var volume: Int
        get() = m.volume
        set(value) {
            m.adjust(value)
        }
}
