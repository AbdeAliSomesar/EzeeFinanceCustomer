package `in`.ezeefinance.customer.payment

import `in`.ezeefinance.customer.R
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
    }

     companion object: ActivityResultContract<Boolean?,Boolean>(){
         override fun createIntent(context: Context, input: Boolean?) = Intent().apply {
             setClass(context, PaymentActivity::class.java)
         }

         override fun parseResult(resultCode: Int, intent: Intent?) =
             resultCode == RESULT_OK
     }
}