package decorator

/**
 * 移譲に関するコードは親クラスのデコレーターに書いてしまい、
 * テンプレートメソッドのように必要なメソッドだけかく。
 */
class LongDialModem(argModem: Modem) : ModemDecorator(argModem) {
    override fun dial(pno: String) {
        m.adjust(11)
        m.dial(pno)
    }
    override fun adjust(volume: Int) {
        m.adjust(volume)
    }
}