package `in`.ezeefinance.customer.project

import `in`.ezeefinance.customer.entities.EMIInfo
import `in`.ezeefinance.customer.entities.EMIState
import `in`.ezeefinance.customer.entities.LoanDetails
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProjectHomeViewModel : ViewModel() {
    val emiAdapter by lazy {
        EmiAdapter().apply {
            submitList(emiList)
        }
    }
    val loanDetails = MutableLiveData(LoanDetails("DMI001342535", 15000.0, 4999.0, " 5th jul 22"))
    var selectedEmi = MutableLiveData(EMIInfo("Jan", 1999.0, EMIState.PENDING))
    private val emiList = listOf(
        EMIInfo(
            "Dec", 4999.0, EMIState.PAID,
            LoanDetails("DMI001342535", 15000.0, 4999.0, " 5th jul 22")
        ),
        EMIInfo("Jan", 1999.0, EMIState.PENDING),
        EMIInfo("Feb", 1999.0, EMIState.REMAINING),
        EMIInfo("Mar", 1999.0, EMIState.REMAINING),
        EMIInfo("Apr", 1999.0, EMIState.REMAINING),
        EMIInfo("May", 1999.0, EMIState.REMAINING),
        EMIInfo("Jun", 1999.0, EMIState.REMAINING),
        EMIInfo("Jul", 1999.0, EMIState.REMAINING),
    )
}