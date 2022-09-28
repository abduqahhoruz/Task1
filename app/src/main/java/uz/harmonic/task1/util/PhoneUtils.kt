package uz.harmonic.task1.util

import android.widget.EditText
import android.widget.TextView
import com.redmadrobot.inputmask.MaskedTextChangedListener


object PhoneUtils {
    fun addMask(phone: EditText) {
        val format = FormSettings.COUNTRY_CODE + FormSettings.PHONE_FORMAT

        val listener = MaskedTextChangedListener(
            format, true, phone,
            null, null
        )

        phone.addTextChangedListener(listener)
        phone.onFocusChangeListener = listener

        if (phone.text.isNullOrEmpty()) {
            phone.setText(FormSettings.COUNTRY_CODE, TextView.BufferType.EDITABLE)
        }
    }
}
