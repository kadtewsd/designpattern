package state.turnstile

import state.TurnstileState
import state.Turnstile

/**
 * ステートのサブクラスです。解錠中を表します。
 */
class UnlockedTurnstileState : TurnstileState {
    override fun coin(t: Turnstile) {
        t.thankyou()
    }

    override fun pass(t: Turnstile) {
        t.changeLocked()
        t.lock()
    }
}