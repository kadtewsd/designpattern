package extensionobject

class Assembly(override val partNumber: String, override val description: String) : Part() {

    private val list = mutableListOf<Part>()
    init {
        addExtension("CSV", CSVAssemblyExtension(this))
        addExtension("XML", XMLAssemblyExtension(this))
    }
    fun add(p: Part) {
        this.list.add(p)
    }

    fun getParts(): Iterator<Part> {
        return this.list.iterator()
    }
}