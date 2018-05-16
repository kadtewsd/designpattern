package reportvisitor

interface Part {
    val partNumber: String
    val description: String
    fun accept(v: PartVisitor)
}