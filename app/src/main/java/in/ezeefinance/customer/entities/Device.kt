package `in`.ezeefinance.customer.entities

data class Device(
    val id: String,
    val model: String? = null,
    val price: Double? = null,
    val downPayment: Double? = null,
    val processingFee: Double? = null,
    val processorName: String? = null,
    val camara: String? = null,
    val size: String? = null,
    val battery: String? = null,
    val imageUrl: String? = null,
    val tenures: List<Int> = listOf(),
    var selectedTenure: Int? = null,
    val colors: List<DeviceColor> = listOf(),
    var selectedColor: DeviceColor? = null,
    val emiAmount: Double? = null
)


data class DeviceColor(
    val name: String = "",
    val code: String? = null
)