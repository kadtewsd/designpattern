package acyclicvisitor

interface ModemVisitor {
    fun visit(v:HaynesModem)
    fun visit(v:ZoomModem)
    fun visit(v:ErnieModem)
}