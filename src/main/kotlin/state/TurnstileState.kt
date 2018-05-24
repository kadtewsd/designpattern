package state

/**
 * ステートのインターフェースです。
 */
interface TurnstileState {
    fun coin(t:Turnstile)
    fun pass(t:Turnstile)
}

