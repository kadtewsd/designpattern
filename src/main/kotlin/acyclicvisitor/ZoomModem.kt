package acyclicvisitor

class ZoomModem : Modem<ModemVisitor> {

    var configurationValue: Int = -1

    override fun dial(pno: String) {
        println("this is dial")
    }

    override fun hangup() {
        println("this is hangup")
    }

    override fun send(c: Char) {
        println("this is send")
    }

    override fun recv(): Char {
        println("this is recv")
        return 'r'
    }

    override fun accept(v: ModemVisitor) {
        v.visit(this)
    }

    override fun acceptAcyclic(v: AcyclicModemVisitor) {
        try {
            val target =  v as ZoomModemVisitor
            target.visit(this)
        } catch (e: ClassCastException) {
            println("cast error.. ${e.stackTrace}")
            throw e
        }
    }

}