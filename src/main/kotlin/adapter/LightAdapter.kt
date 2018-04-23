package adapter

class LightAdapter : Switchable{
    private val light: Light = Light()

    override fun turnOn(): Boolean {
        return this.light.turnOn()
    }

    override fun turnOff(): Boolean {
        return this.light.turnOff()
    }

}