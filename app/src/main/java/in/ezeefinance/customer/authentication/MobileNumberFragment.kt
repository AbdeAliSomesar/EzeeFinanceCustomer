package `in`.ezeefinance.customer.authentication

import `in`.ezeefinance.customer.R
import `in`.ezeefinance.customer.databinding.FragmentMobileNumberBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController


class MobileNumberFragment : Fragment() {
    private lateinit var binding: FragmentMobileNumberBinding
    private val viewModel by viewModels<AuthenticationViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMobileNumberBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        setUpHeader()
        binding.btnSubmit.setOnClickListener {
            viewModel.sendOTP({
                findNavController().navigate(R.id.action_mobileNumberFragment_to_verifyOtpFragment)
            }, {

            })
        }
    }

    private fun setUpHeader() {
        binding.header.apply {
            tvHeading.text = getString(R.string.sign_up)
            tvTitle.text = getString(R.string.please_sign_in_to_enter_in_a_app)
        }
    }

}