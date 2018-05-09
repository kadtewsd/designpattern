package abstractserver

class Light : Switchable {
    override fun turnOff(): Boolean {
        return true
    }

    override fun turnOn(): Boolean {
        return true
    }
}