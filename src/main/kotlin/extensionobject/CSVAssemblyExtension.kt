package extensionobject

class CSVAssemblyExtension(val p: Assembly) : CSVPartExtension {
    override fun getCSV(): String {
        val stb = StringBuffer("Assembly,")
        stb.append(p.partNumber)
        stb.append(",")
        stb.append(p.description)
        val itr = p.getParts()
        while (itr.hasNext()) {
            stb.append(",{")
            stb.append(
                    (itr.next().getExtension("CSV") as CSVPartExtension)
                            .getCSV()
            )
            stb.append("}")
        }
        return stb.toString()
    }
}