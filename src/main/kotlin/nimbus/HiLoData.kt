package nimbus

interface HiLoData {
    fun currentReding(current: Double, time: Long) : Boolean
    fun newDay(initial: Double, time: Long)
    val highValue: Double
    val highTime: Long
    val lowValue: Double
    val lowTime: Long
}