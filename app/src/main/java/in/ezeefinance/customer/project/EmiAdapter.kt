package `in`.ezeefinance.customer.project

import `in`.ezeefinance.customer.databinding.LayoutEmiListItemBinding
import `in`.ezeefinance.customer.entities.EMIInfo
import `in`.ezeefinance.customer.entities.EMIState
import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

class EmiAdapter : RecyclerView.Adapter<EmiAdapter.ViewHolder>() {

    private var emiList = listOf<EMIInfo>()
    private var onPayNowListener: (() -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        parent.context,
        LayoutEmiListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(emiList[position])
    }

    override fun getItemCount() = emiList.size

    fun submitList(list: List<EMIInfo>) {
        emiList = list
        notifyDataSetChanged()
    }

    fun setClickListener(listener: () -> Unit) {
        onPayNowListener = listener
    }

    inner class ViewHolder(
        private val context: Context,
        private val binding: LayoutEmiListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EMIInfo) {
            binding.item = item
            val color = ContextCompat.getColor(context, item.state.colorId)
            binding.apply {
                val buttonVisible = item.state != EMIState.REMAINING
                btnPay.isVisible = buttonVisible
                tvRemaining.isVisible = !buttonVisible
                tvEmiAmount.setTextColor(color)
                btnPay.backgroundTintList = ColorStateList.valueOf(color)
                btnPay.setOnClickListener {
                    if(item.state == EMIState.PENDING)
                        onPayNowListener?.invoke()
                }
                circularImage.setImageResource(item.state.colorId)
                baseImage.setImageResource(item.state.colorId)
                item.loanDetails?.let {
                    loanDetailsContainer.apply {
                        container.visibility = View.VISIBLE
                        loanDetails = it
                    }
                } ?: kotlin.run {
                    loanDetailsContainer.apply {
                        container.visibility = View.GONE
                    }
                }
            }
        }
    }
}