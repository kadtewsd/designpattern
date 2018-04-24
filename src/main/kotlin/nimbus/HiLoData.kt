package nimbus

interface HiLoData {
    fun currentReding(current: Double, time: Long) : Boolean
    fun newDay(initial: Double, time: Long)
    var highValue: Double
    var highTime: Long
    var lowValue: Double
    var lowTime: Long
}