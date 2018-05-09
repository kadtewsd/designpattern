package acyclicvisitor

class UnixModemConfigurator : ModemVisitor, AcyclicModemVisitor, HaynesModemVisitor, ZoomModemVisitor, ErnieModemVisitor  {

    override fun visit(m: HaynesModem) {
        m.configurationString = "connectionString"
    }

    override fun visit(m: ZoomModem) {
        m.configurationValue = 90
    }

    override fun visit(m: ErnieModem) {
        m.inernalPattern = "internal Pattern"
    }
}