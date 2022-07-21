package `in`.ezeefinance.customer.entities

import `in`.ezeefinance.customer.R
import androidx.annotation.RawRes

data class EMIInfo(
    val month: String,
    val amount: Double,
    val state: EMIState,
    val loanDetails:LoanDetails? = null
)

enum class EMIState(@RawRes val colorId: Int, val text: String) {
    PAID(R.color.colorPrimary,"PAID"),
    PENDING(R.color.color_orange, "PAY NOW"),
    REMAINING(R.color.colorPrimaryVariant, "REMAINING")
}

data class LoanDetails(
    val id: String,
    val totalAmount:Double,
    val paid: Double,
    val DueDate: String
)