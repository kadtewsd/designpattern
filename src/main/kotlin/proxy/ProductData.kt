package proxy

class ProductData(val name: String, val price: Int, val sku: String) {
    override fun equals(other: Any?): Boolean {
        if (other !is ProductData) return false
        return name == other.name &&
                sku == other.sku;

    }
}