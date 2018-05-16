package reportvisitor

class ExplodedCostVisitor : PartVisitor {

    var _cost: Int = 0
    var cost: Int
        get() = this._cost
        set(value) {
            this._cost = value
        }


    override fun visit(pp: PiecePart) {
        this.cost += pp.cost
    }

    override fun visit(a: Assembly) {
    }

}