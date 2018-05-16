package reportvisitor

interface PartVisitor {
    fun visit(pp: PiecePart)
    fun visit(a: Assembly)
}