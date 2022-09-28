package uz.harmonic.task1.data

import uz.harmonic.task1.domen.User

interface Pref {
    var user: User?

    fun clearAll()

    companion object {
        const val PREF_NAME = "task1"
        const val USER = "user"
    }
}