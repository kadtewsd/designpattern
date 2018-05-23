package state

import state.turnstile.LockedTurnstileState
import state.turnstile.UnlockedTurnstileState

class Turnstile(val turnstileController: TurnstileController){
    var state = Turnstile.LOCKED
    companion object {
        val LOCKED: TurnstileState = LockedTurnstileState()
        val UNLOCKED: TurnstileState = UnlockedTurnstileState()
    }

    fun coin() {
        state.coin(this)
    }

    fun pass() {
        state.pass(this)
    }

    fun changeLocked() {
        state = LOCKED
    }

    fun changeUnlocked() {
        state = UNLOCKED
    }

    fun isLocked(): Boolean {
        return state == LOCKED
    }

    fun isUnlocked(): Boolean {
        return state == UNLOCKED
    }

    fun thankyou() {
        turnstileController.thankyou()
    }

    fun alarm() {
        turnstileController.alarm()
    }

    fun lock() {
        turnstileController.lock()
    }

    fun unlock() {
        turnstileController.unlock()
    }

    fun state(): TurnstileState {
        return state
    }
}