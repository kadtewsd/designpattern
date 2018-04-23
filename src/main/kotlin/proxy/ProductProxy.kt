package proxy

/**
 * 本来は ProductImpl に Proxy 後の処理を移譲するがそんなことは不要であった。
 */
class ProductProxy(override val sku: String) : Product {
    override val name: String
        get() = DBAccess.getProductData(sku).name

    override val price: Int
        get() = DBAccess.getProductData(sku).price
}
