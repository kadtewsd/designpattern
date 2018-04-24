package nimbus

import java.util.*

interface AlarmListener : EventListener {
    fun wakeup()
}