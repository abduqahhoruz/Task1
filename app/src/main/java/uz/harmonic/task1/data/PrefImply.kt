package uz.harmonic.task1.data

import android.content.SharedPreferences
import com.google.gson.Gson
import uz.harmonic.task1.domen.User
import javax.inject.Inject

class PrefImpl @Inject constructor(
    private val prefs: SharedPreferences,
) : Pref {
    private val gson = Gson()
    override var user: User?
        get() = gson.fromJson(prefs.getString(Pref.USER, null), User::class.java)
        set(value) {
            prefs.edit().putString(Pref.USER, gson.toJson(value)).apply()
        }

    override fun clearAll() {
        prefs.edit().clear().apply()
    }

}