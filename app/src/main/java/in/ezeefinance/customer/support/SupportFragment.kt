package `in`.ezeefinance.customer.support

import `in`.ezeefinance.customer.databinding.FragmentSupportBinding
import `in`.ezeefinance.customer.project.ProjectHomeActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels


class SupportFragment : Fragment() {
    private lateinit var binding: FragmentSupportBinding
    private val viewModel by viewModels<SupportViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSupportBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        setUpHeader()
        binding.viewModel = viewModel
        binding.nameContainer.editText?.setText("Cameron Williamson")
        binding.emailContainer.editText?.setText("dummyemail@gmail.com")
    }

    private fun setUpHeader() {
        (activity as ProjectHomeActivity).setTitle("Support")
    }
}