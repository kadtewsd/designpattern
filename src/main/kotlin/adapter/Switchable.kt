package adapter

/**
 * インターフェースはクライアントに属するものであり、
 * 継承先のクラスに属さない。
 * そのため、いたーフェース名はクライアントに依存する。
 */
interface Switchable {
    fun turnOn(): Boolean
    fun turnOff(): Boolean
}