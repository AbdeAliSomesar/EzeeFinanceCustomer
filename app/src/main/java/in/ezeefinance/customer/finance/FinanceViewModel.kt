package `in`.ezeefinance.customer.finance

import `in`.ezeefinance.customer.entities.Device
import `in`.ezeefinance.customer.entities.DeviceColor
import androidx.lifecycle.ViewModel

class FinanceViewModel: ViewModel() {
    val deviceListAdapter by lazy {
        DeviceListAdapter().apply {
            submitList(getDeviceList())
        }
    }

    private fun getDeviceList() = mutableListOf<Device>().apply {
        for (i in 1..30) {
            add(
                Device(
                    "$i",
                    "Samsung Galaxy M53",
                    28466.0,
                    5000.0,
                    1999.0,
                    "Media MT6594",
                    "64MP+5MP+2MP",
                    "6.6 Inches",
                    "5000 mAh",
                    "",
                    listOf(
                        8, 5, 4
                    ), 8,
                    listOf(
                        DeviceColor("Red", "#DF2A2A"),
                        DeviceColor("Black", "#000000"),
                        DeviceColor("Blue", "#1B1F84")
                    ),
                    null,
                    1999.0
                )
            )
        }
    }
}