package activeobject

import java.util.*

fun main(args:Array<String>) {
    for (i in 1..100) {
        println("-----------------------------------")
        println("start Active Object Pattern...")
        println()
        val engine = ActiveObjectEngine()
        engine
                .addCommand(SimpleCommand(name = "Simple Command A", value = "1"))
                .addCommand(SimpleCommand(name = "Simple Command B", value = "3"))
                .addCommand(SleepCommand(name = "Sleep Command C", sleepTime = 1, engine = engine, wakeupCommand = SimpleCommand("Wake up command C", value = "9"), value = "5"))
                .addCommand(SimpleCommand(name = "Simple Command D", value = "7"))
                .addCommand(SimpleCommand(name = "Simple Command E", value = "1"))
                .addCommand(SimpleCommand(name = "Simple Command F", value = "3"))
                .addCommand(SleepCommand(name = "Sleep Command G", sleepTime = 1, engine = engine, wakeupCommand = SimpleCommand("Wake up command G", value = "11"), value = "5"))
                .addCommand(SimpleCommand(name = "Simple Command H", value = "7"))
                .run()
        println("-----------------------------------")
    }
}
class ActiveObjectEngine {

    private val itsCommand: LinkedList<Command> = LinkedList()

    fun addCommand(command: Command): ActiveObjectEngine {
        this.itsCommand.add(command)
        return this
    }

    fun run() {
        // リストにたまりすぎてしまうので、リストを削除できない、forEach を使用せず、while で使用したコマンドを削除する。
//        for (command in this.itsCommand) {
        while (!this.itsCommand.isEmpty()) {
            val command = this.itsCommand.first
            command.execute()
            this.itsCommand.removeFirst()
        }
    }
}