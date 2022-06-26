package `in`.ezeefinance.customer

import `in`.ezeefinance.customer.authentication.AuthenticationActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private val authenticationActivity = registerForActivityResult(AuthenticationActivity) {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        authenticationActivity.launch(null)
    }
}