package `in`.ezeefinance.customer.authentication

import `in`.ezeefinance.customer.R
import `in`.ezeefinance.customer.databinding.FragmentVerifyOtpBinding
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

class VerifyOtpFragment : Fragment(), View.OnKeyListener, View.OnFocusChangeListener {
    private lateinit var binding: FragmentVerifyOtpBinding
    private val viewModel by viewModels<AuthenticationViewModel>()
    private var deleted = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVerifyOtpBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        setUpHeader()
        setUpOTPContainer()
        activity?.onBackPressedDispatcher?.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                viewModel.otp.value = ""
                findNavController().navigateUp()
            }
        })
        binding.btnSubmit.setOnClickListener {

        }
    }

    private fun setUpHeader() {
        binding.header.apply {
            tvHeading.text = getString(R.string.verification)
            tvTitle.text = String.format(
                getString(R.string.kindly_enter_verification_code_sent_to_number),
                viewModel.mobile.value
            )
        }
    }

    private fun setUpOTPContainer() {
        binding.apply {
            digit1.doAfterTextChanged {
                if (!it.isNullOrBlank()) {
                    digit2.requestFocus()
                    viewModel.count++
                }
            }
            digit2.doAfterTextChanged {
                if (!it.isNullOrBlank()) {
                    digit3.requestFocus()
                    viewModel.count++
                }
            }
            digit3.doAfterTextChanged {
                if (!it.isNullOrBlank()) {
                    digit4.requestFocus()
                    viewModel.count++
                }
            }
            digit2.setOnKeyListener(this@VerifyOtpFragment)
            digit3.setOnKeyListener(this@VerifyOtpFragment)
            digit4.setOnKeyListener(this@VerifyOtpFragment)
            digit2.onFocusChangeListener = this@VerifyOtpFragment
            digit3.onFocusChangeListener = this@VerifyOtpFragment
            digit4.onFocusChangeListener = this@VerifyOtpFragment


        }
    }

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_DEL && event?.action == KeyEvent.ACTION_DOWN) {
            binding.apply {
                when (v?.id) {
                    digit2.id -> {
                        if (digit2.text.isNullOrBlank() && !deleted) {
                            digit1.setText("")
                            digit1.requestFocus()
                        }
                    }
                    digit3.id -> {
                        if (digit3.text.isNullOrBlank() && !deleted) {
                            digit2.setText("")
                            digit2.requestFocus()
                        }
                    }
                    digit4.id -> {
                        if (digit4.text.isNullOrBlank() && !deleted) {
                            digit3.setText("")
                            digit3.requestFocus()
                        }
                    }
                }
            }
        }

        return true
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        if (hasFocus)
            binding.apply {
                when (v?.id) {
                    digit4.id -> {
                        if (digit3.text.isNullOrBlank())
                            digit3.requestFocus()
                    }
                    digit3.id -> {
                        if (digit2.text.isNullOrBlank())
                            digit2.requestFocus()
                    }
                    digit2.id -> {
                        if (digit1.text.isNullOrBlank())
                            digit1.requestFocus()
                    }
                }
            }
    }
}