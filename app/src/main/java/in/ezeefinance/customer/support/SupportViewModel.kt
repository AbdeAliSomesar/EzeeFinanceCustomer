package `in`.ezeefinance.customer.support

import `in`.ezeefinance.customer.utils.Constants
import androidx.lifecycle.ViewModel

class SupportViewModel: ViewModel() {
    val nameMaxLength = Constants.NAME_MAX_LENGTH
    val supportMessageMaxLength = Constants.SUPPORT_MESSAGE_MAX_LENGTH
}