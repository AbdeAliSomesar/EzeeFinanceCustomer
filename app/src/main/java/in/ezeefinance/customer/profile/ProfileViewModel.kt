package `in`.ezeefinance.customer.profile

import `in`.ezeefinance.customer.entities.UserInfo
import androidx.lifecycle.ViewModel

class ProfileViewModel: ViewModel() {
    val user = UserInfo(
        "1",
        "Cameron Williamson",
        "(808) 555-0111",
        "dummyemail@gmail.com",
        "Male",
        "30/05/1999",
        "2464 Royal Ln. Mesa, New 45463",
        "152107",
        "PAN number",
        "654812364123"
    )
}