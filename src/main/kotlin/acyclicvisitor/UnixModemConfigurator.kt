package acyclicvisitor

class UnixModemConfigurator : ModemVisitor, AcyclicModemVisitor, HaynesModemVisitor, ZoomModemVisitor, ErnieModemVisitor  {

    override fun visit(v: HaynesModem) {
        v.configurationString = "connectionString"
    }

    override fun visit(v: ZoomModem) {
        v.configurationValue = 90
    }

    override fun visit(v: ErnieModem) {
        v.inernalPattern = "internal Pattern"
    }
}