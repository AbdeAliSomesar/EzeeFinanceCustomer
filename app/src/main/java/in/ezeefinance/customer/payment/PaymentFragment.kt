package `in`.ezeefinance.customer.payment

import `in`.ezeefinance.customer.R
import `in`.ezeefinance.customer.databinding.FragmentPaymentBinding
import `in`.ezeefinance.customer.project.ProjectHomeViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class PaymentFragment : Fragment() {

    private lateinit var binding: FragmentPaymentBinding
    private val viewModel by activityViewModels<ProjectHomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaymentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        viewModel.selectedEmi.observe(viewLifecycleOwner) { emi ->
            emi?.let { emi ->
                binding.viewModel = viewModel
                binding.apply {
                    viewModel?.loanDetails?.value?.let { loanDetails ->
                        tvRemainingAmount.text =
                            getString(R.string.remaining_payment,loanDetails.totalAmount - loanDetails.paid)
                    }
                }
            }
        }
        binding.apply {
            collectOnlineCard.apply {
                tvTitle.text = getString(R.string.collect_now)
                tvDescription.text = getString(R.string.share_payment_link_and_receive_your_amount)
                btnPay.text = getString(R.string.share_link)
            }
            cashCard.apply {
                tvTitle.text = getString(R.string.cash_payment)
                tvDescription.text =
                    getString(R.string.lorem_ipsum_has_been_the_industry_s_standard)
                btnPay.text = getString(R.string.collect_cash)
            }

        }
    }
}