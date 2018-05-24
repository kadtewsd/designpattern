package state

/**
 * アクション用のインターフェースです
 */
interface TurnstileController {
    fun lock()
    fun unlock()
    fun thankyou()
    fun alarm()
}