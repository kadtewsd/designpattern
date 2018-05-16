package reportvisitor

class PiecePart(override val partNumber: String, override val description: String, val cost: Int) : Part {
    override fun accept(v: PartVisitor) {
        v.visit(this)
    }
}