package `in`.ezeefinance.customer.utils

import android.content.Context
import android.os.Handler
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.showKeyboard(context: Context?) {
    Handler().postDelayed({
        (context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }, 0)
}