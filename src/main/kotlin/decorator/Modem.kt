package decorator

/**
 * Decorator は Proxy に似ているが、
 *  Proxy : 内部で移譲クラスを持つ。(パターンが決まりきっている)
 *  Decorator : 外部で移譲クラスを渡す。(パターンが組み合わせである)
 *  という違いがある。
 */
interface Modem {
    fun dial(pno: String)
    fun adjust(volume: Int)
    val phoneNumber:String
    var volume: Int
}