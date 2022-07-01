package `in`.ezeefinance.customer.entities

import `in`.ezeefinance.customer.R
import androidx.annotation.RawRes

data class EMIInfo(
    val month: String,
    val amount: Double,
    val state: EMIState,
    val colorCode: String
)

enum class EMIState(@RawRes val colorId: Int) {
    PAID(R.color.colorPrimary),
    PENDING(R.color.color_orange),
    REMAINING(R.color.colorPrimaryVariant)
}
