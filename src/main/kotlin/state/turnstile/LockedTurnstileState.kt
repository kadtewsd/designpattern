package state.turnstile

import state.Turnstile
import state.TurnstileState

class LockedTurnstileState : TurnstileState {
    override fun coin(t: Turnstile) {
        t.changeUnlocked()
        t.unlock()
    }

    override fun pass(t: Turnstile) {
        t.alarm()
    }
}
