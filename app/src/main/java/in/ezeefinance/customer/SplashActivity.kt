package `in`.ezeefinance.customer

import `in`.ezeefinance.customer.authentication.AuthenticationActivity
import `in`.ezeefinance.customer.project.ProjectHomeActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private val authenticationActivity = registerForActivityResult(AuthenticationActivity) {}
    private val projectHomeActivity = registerForActivityResult(ProjectHomeActivity) {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //authenticationActivity.launch(null)
        projectHomeActivity.launch(null)
    }

    private fun setUp() {

    }


}