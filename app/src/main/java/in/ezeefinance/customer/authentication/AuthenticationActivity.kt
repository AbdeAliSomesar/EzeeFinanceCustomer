package `in`.ezeefinance.customer.authentication

import `in`.ezeefinance.customer.R
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity

class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication_actiivty)
    }

    companion object : ActivityResultContract<Boolean?, Boolean>() {
        override fun createIntent(context: Context, input: Boolean?) = Intent().apply {
            setClass(context, AuthenticationActivity::class.java)
        }

        override fun parseResult(resultCode: Int, intent: Intent?) = resultCode == RESULT_OK

    }
}