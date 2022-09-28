package uz.harmonic.task1.data

import uz.harmonic.task1.domen.User

interface Repo {
    fun signUpUser(user: User)
    fun logOut()
}