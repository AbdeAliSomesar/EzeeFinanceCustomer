package `in`.ezeefinance.customer.splash

import `in`.ezeefinance.customer.R
import `in`.ezeefinance.customer.authentication.AuthenticationActivity
import `in`.ezeefinance.customer.project.ProjectHomeActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private val projectHomeActivity = registerForActivityResult(ProjectHomeActivity){}
    private val authenticationActivity = registerForActivityResult(AuthenticationActivity) {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUp()
    }

    private fun setUp() {
    Handler().postDelayed(
        {
           // projectHomeActivity.launch(null)
            authenticationActivity.launch(null)
            finish()
        },
        3000
    )
    }
}