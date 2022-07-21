package `in`.ezeefinance.customer.project

import `in`.ezeefinance.customer.databinding.FragmentProjectHomeBinding
import `in`.ezeefinance.customer.payment.PaymentActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class ProjectHomeFragment : Fragment() {
    private lateinit var binding: FragmentProjectHomeBinding
    private val viewModel by activityViewModels<ProjectHomeViewModel>()
    private val paymentActivity = registerForActivityResult(PaymentActivity){}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProjectHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        setUpHeader()
        binding.viewModel = viewModel
        viewModel.emiAdapter.setClickListener {
            paymentActivity.launch(null)
        }
        binding.apply {
        }
    }

    private fun setUpHeader() {
        (activity as ProjectHomeActivity).setTitle("Hi! Robert Fox ")
    }
}