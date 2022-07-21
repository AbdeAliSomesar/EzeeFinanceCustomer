package `in`.ezeefinance.customer.project

import `in`.ezeefinance.customer.R
import `in`.ezeefinance.customer.databinding.ActivityProjectHomeBinding
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class ProjectHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProjectHomeBinding
    private val viewModel by viewModels<ProjectHomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBar()
        setUpBottomNav()
    }

    private fun setUpBottomNav() {
        binding.apply {
            val navController =
                (supportFragmentManager
                    .findFragmentById(R.id.nav_host_fragment_container)
                        as NavHostFragment)
                    .navController
            NavigationUI.setupWithNavController(
                bottomNavigationView, navController
            )
        }
    }

    fun setTitle(title:String){
        binding.header.tvHeading.text = title
    }

    fun setStatusBar(){
        window?.insetsController?.setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS)
    }

    companion object : ActivityResultContract<Boolean?, Boolean>() {
        override fun createIntent(context: Context, input: Boolean?) = Intent().apply {
            setClass(context, ProjectHomeActivity::class.java)
        }

        override fun parseResult(resultCode: Int, intent: Intent?) = resultCode == RESULT_OK

    }

}