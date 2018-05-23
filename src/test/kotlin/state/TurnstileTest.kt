package state

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TurnstileTest {

    private lateinit var controller: TurnstileController
    private lateinit var turnstile: Turnstile

    var lockCalled = false
    var unlockCalled = false
    var thankyouCalled = false
    var alarmCalled = false


    @BeforeEach
    fun setUp() {
        // 無名クラス
        controller = object : TurnstileController
        {
            override fun lock() {
                lockCalled = true
            }

            override fun unlock() {
                unlockCalled = true
            }

            override fun thankyou() {
                println("てんきゅー")
                thankyouCalled = true
            }

            override fun alarm() {
                alarmCalled = true
            }
        }
        turnstile = Turnstile(controller)
    }

    @Test
    fun testInitial() {
        assertEquals(Turnstile.LOCKED, turnstile.state())
    }

    @Test
    fun testUnlocked() {
        turnstile.state = Turnstile.LOCKED
        turnstile.coin()
        assertEquals(Turnstile.UNLOCKED, turnstile.state())
        assertTrue(unlockCalled)
    }

    @Test
    fun testCoinInUnlockedState() {
        turnstile.state = Turnstile.UNLOCKED
        turnstile.coin()
        assertEquals(Turnstile.UNLOCKED, turnstile.state)
        assertTrue(thankyouCalled)
    }

    @Test
    fun testPassInLockedState() {
        turnstile.state = Turnstile.LOCKED
        turnstile.pass()
        assertEquals(Turnstile.LOCKED, turnstile.state)
        assertTrue(alarmCalled)
    }

    @Test
    fun testPassInUnLockedState() {
        turnstile.state = Turnstile.UNLOCKED
        turnstile.pass()
        assertEquals(Turnstile.LOCKED, turnstile.state)
        assertTrue(lockCalled)
    }

}