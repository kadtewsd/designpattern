package reportvisitor

class PartCountVisitor : PartVisitor {

    var itemCount = 0
    val map = HashMap<String, Int>()

    override fun visit(pp: PiecePart) {
        itemCount++
        var partNumberCount = 0

        if (map.containsKey(pp.partNumber)) {
            partNumberCount = when (map.get(pp.partNumber)) {
                null -> 0
                else -> map.get(pp.partNumber) as Int
            }
        }
        partNumberCount++
        map.put(pp.partNumber, partNumberCount)
    }

    override fun visit(a: Assembly) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun countForPart(number: String): Int {
        return when (map.get(number)) {
            null -> 0
            else -> map.get(number) as Int
        }
    }

}