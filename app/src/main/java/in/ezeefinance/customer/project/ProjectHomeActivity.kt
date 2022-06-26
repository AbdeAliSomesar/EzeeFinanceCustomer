package `in`.ezeefinance.customer.project

import `in`.ezeefinance.customer.R
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity

class ProjectHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_home)
    }

    companion object : ActivityResultContract<Boolean?, Boolean>() {
        override fun createIntent(context: Context, input: Boolean?) = Intent().apply {
            setClass(context, ProjectHomeActivity::class.java)
        }

        override fun parseResult(resultCode: Int, intent: Intent?) = resultCode == RESULT_OK

    }
}