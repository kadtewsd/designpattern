package reportvisitor

class Assembly(override val partNumber: String, override val description: String) : Part {

    var list: MutableList<Part> = mutableListOf()

    override fun accept(v: PartVisitor) {
        v.visit(this)
        val parts  = parts
        while (parts.hasNext()) {
            val part = parts.next()
            part.accept(v)
        }
    }

    fun add(p:Part) {
        this.list.add(p)
    }

    val parts: Iterator<Part>
        get() = this.list.iterator()
}