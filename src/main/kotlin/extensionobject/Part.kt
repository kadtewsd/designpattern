package extensionobject

abstract class Part {
    val extension = HashMap<String, PartExtension>();
    abstract val partNumber: String
    abstract val description: String
    fun addExtension(extensionType: String, extension: PartExtension) {
        this.extension.put(extensionType, extension)
    }

    fun getExtension(extensionType: String): PartExtension {
        return when (this.extension.get(extensionType)) {
            null -> BadPartExtension()
            else ->  {
                this.extension.get(extensionType) as PartExtension
            }
        }
    }
}