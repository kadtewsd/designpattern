package extensionobject

class PiecePart(override val partNumber: String, override val description: String, val cost: Double) : Part() {
    init {
        addExtension("CSV", CSVPiecePartExtension(this))
        addExtension("XML", XMLPiecePartExtension(this))
    }
}