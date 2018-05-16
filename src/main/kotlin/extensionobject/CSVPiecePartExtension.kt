package extensionobject

class CSVPiecePartExtension(val p: PiecePart) : CSVPartExtension {
    override fun getCSV(): String {
        val stb = StringBuffer("PiecePart,")
        stb.append(p.partNumber)
        stb.append(",")
        stb.append(p.description)
        stb.append(",")
        stb.append(p.cost)
        return stb.toString()
    }
}