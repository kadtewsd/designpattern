package proxy

class OrderData() {

    var orderId: Int = 0
    var customerId: String = ""

    constructor(orderId: Int, customerId: String): this() {
        this.orderId = orderId
        this.customerId = customerId
    }
}