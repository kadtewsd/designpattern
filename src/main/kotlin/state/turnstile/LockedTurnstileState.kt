package state.turnstile

import state.Turnstile
import state.TurnstileState

/**
 * ステートの派生クラスです。施錠中を表します。
 */
class LockedTurnstileState : TurnstileState {
    override fun coin(t: Turnstile) {
        t.changeUnlocked()
        t.unlock()
    }

    override fun pass(t: Turnstile) {
        t.alarm()
    }
}
