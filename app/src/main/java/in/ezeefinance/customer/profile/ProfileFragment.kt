package `in`.ezeefinance.customer.profile

import `in`.ezeefinance.customer.databinding.FragmentProfileBinding
import `in`.ezeefinance.customer.project.ProjectHomeActivity
import `in`.ezeefinance.customer.project.ProjectHomeViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val viewModel by viewModels<ProfileViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        setUpHeader()
        binding.user = viewModel.user
    }

    private fun setUpHeader() {
        (activity as ProjectHomeActivity).setTitle("Profile")
    }
}