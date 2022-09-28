package uz.harmonic.task1.data

import uz.harmonic.task1.domen.User
import javax.inject.Inject

class RepoImp @Inject constructor(private val pref: Pref) : Repo {

    override fun signUpUser(user: User) {
        pref.user = user
    }

    override fun logOut() {
        pref.clearAll()
    }


}