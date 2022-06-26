package `in`.ezeefinance.customer.authentication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthenticationViewModel : ViewModel() {
    var count = 0
    val mobile = MutableLiveData("")
    val otp = MutableLiveData("")

    fun sendOTP(onSuccess: () -> Unit, onError: (message: String) -> Unit) = when {
        else -> onSuccess()
    }

    fun verifyOTP(onVerify: () -> Unit, onError: (message: String) -> Unit) = when {
        else -> onVerify()
    }

}