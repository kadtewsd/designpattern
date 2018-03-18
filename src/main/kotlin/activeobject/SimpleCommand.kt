package activeobject

class SimpleCommand(private val name:String, private val value:String) : Command {

    override fun execute() {
        println("value is $value. executed by $name.")
    }
}