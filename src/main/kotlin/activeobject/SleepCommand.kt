package activeobject

class SleepCommand(private val name: String, private val sleepTime: Long, private val value: String, private val engine: ActiveObjectEngine, private val wakeupCommand: Command) : Command {

    private var started: Boolean = false
    private var startTime: Long = 0

    override fun execute() {
        val currentTime = System.currentTimeMillis();
        if (!started) {
            println("$name is started. value is $value. current time is $currentTime")
            started = true
            this.startTime = currentTime
            this.engine.addCommand(this)
            return
        }
        val waitTIme = currentTime - this.startTime
        if (waitTIme < sleepTime) { // 始まってからスリープする時間より小さかったら、この判定をやり直すよう自分自身を次のコマンドにセット
            this.engine.addCommand(this)
        } else { // 必要な時間休んだら次のコマンド
            println("$name does next. value is $value. . wait time is $waitTIme")
            this.engine.addCommand(wakeupCommand)
        }
    }
}