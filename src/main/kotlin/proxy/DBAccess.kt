package proxy

class DBAccess {
    companion object {
        var list:MutableList<ItemData> = arrayListOf()
        fun getProductData(sku:String) : ProductData {
            return ProductData("hoge", 2000, sku)
        }

        fun registerNewOrder(customerId: String): OrderData {
            return OrderData(1, customerId)
        }

        fun getOrderData(orderId:Int): OrderData {
            return OrderData(1, "kasakaid")
        }

        fun getItemsForOrder(orderId: Int): MutableList<ItemData> {
            return arrayListOf(
                ItemData(1, 1, "radio"),
                    ItemData(1, 1, "book"),
                    ItemData(2, 10, "office"),
                    ItemData(3, 11, "license"),
                    ItemData(3, 11, "sake")
            );

        }

        fun store(itemData:ItemData) {
            list.add(itemData)
        }
    }
}