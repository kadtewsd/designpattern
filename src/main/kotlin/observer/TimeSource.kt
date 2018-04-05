package observer

interface TimeSource {
    fun hours(): Int
    fun minutes(): Int
    fun seconds(): Int
}