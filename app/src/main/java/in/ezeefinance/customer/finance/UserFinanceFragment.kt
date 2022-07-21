package `in`.ezeefinance.customer.finance

import `in`.ezeefinance.customer.databinding.FragmentUserFinanceBinding
import `in`.ezeefinance.customer.project.ProjectHomeActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration


class UserFinanceFragment : Fragment() {

    private lateinit var binding: FragmentUserFinanceBinding
    private val viewModel by activityViewModels<FinanceViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserFinanceBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp(){
        setUpHeader()
        binding.apply {
            viewModel = this@UserFinanceFragment.viewModel
            rvDeviceList.addItemDecoration(
                DividerItemDecoration(context,DividerItemDecoration.VERTICAL)
            )
        }
    }
    private fun setUpHeader(){
        (activity as ProjectHomeActivity).setTitle("Your Finance")
    }

}