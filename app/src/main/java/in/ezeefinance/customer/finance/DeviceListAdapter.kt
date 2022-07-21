package `in`.ezeefinance.customer.finance

import `in`.ezeefinance.customer.databinding.LayoutDeviceListItemBinding
import `in`.ezeefinance.customer.entities.Device
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DeviceListAdapter : RecyclerView.Adapter<DeviceListAdapter.ViewHolder>() {

    var deviceList = mutableListOf<Device>()
    private var onSelect: ((device: Device) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutDeviceListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ), parent.context
    )

    fun submitList(list: MutableList<Device>) {
        deviceList = list
        notifyDataSetChanged()
    }

    fun setSelectListener(listener: (device: Device) -> Unit) {
        onSelect = listener
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(deviceList[position])
    }

    override fun getItemCount() = deviceList.size


    inner class ViewHolder(private val binding: LayoutDeviceListItemBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Device) {
            binding.apply {
                this.item = item
            }
        }
    }
}