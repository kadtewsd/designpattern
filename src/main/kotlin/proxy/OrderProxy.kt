package proxy

class OrderProxy(var orderId: Int) : Order {

    private fun orderId() : Int {
        this.orderId = 1;
        return this.orderId
    }

    override val customerId: String
        get() = DBAccess.getOrderData(this.orderId()).customerId

    override fun total(): Int {
        val imp = OrderImpl(this.customerId)
        DBAccess.getItemsForOrder(this.orderId).forEach {imp.addItem(ProductProxy(it.sku), it.qty)}
        return imp.total()


    }
    override fun addItem(p: Product, quantity: Int) {
        DBAccess.store(ItemData(this.orderId, quantity, p.sku))
    }
}