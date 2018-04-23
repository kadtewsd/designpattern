package proxy

class ItemData {
    var orderId = 0
    var qty = 0
    var sku = ""
    constructor(orderId:Int,qty: Int, sku: String) {
        this.orderId = orderId
        this.qty = qty
        this.sku = sku
    }
}