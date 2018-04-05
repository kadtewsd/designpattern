package observer

abstract class Subject {

    // このインターフェースだと ClockDriver しか TimeSource を使えない。
//    fun setDriver(driver: ClockDriver);
    val observers: MutableList<Observer> = arrayListOf()

    fun registerObserver(driver: Observer) {
        this.observers.add(driver)
    }

    fun notifyObservers() {
        this.observers.forEach { it.update() }
    }
}