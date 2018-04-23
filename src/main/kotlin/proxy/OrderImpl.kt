package proxy

class OrderImpl(override val customerId: String) : Order {
    override fun addItem(p: Product, quantity: Int) {
        val item = Item(p, quantity)
        items.add(item)
    }

    override fun total(): Int {
        return items.sumBy { it.p.price + it.qty}
    }

    val items:MutableList<Item> = arrayListOf()
}