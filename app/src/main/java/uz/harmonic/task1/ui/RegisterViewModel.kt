package uz.harmonic.task1.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.harmonic.task1.data.Repo
import uz.harmonic.task1.domen.User
import javax.inject.Inject


interface RegisterViewModelInterface{
    fun register(user: User)
}
@HiltViewModel
class RegisterViewModel @Inject constructor(private val repo: Repo) : ViewModel(),
    RegisterViewModelInterface {
    override fun register(user: User) {
        repo.signUpUser(user)
    }
}