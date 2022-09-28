package uz.harmonic.task1.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.harmonic.task1.data.Repo
import javax.inject.Inject


interface WelcomeViewModelInterface {
    fun logOut()
}

@HiltViewModel
class WelcomeViewModel @Inject constructor(private val repo: Repo) : ViewModel(),
    WelcomeViewModelInterface {
    override fun logOut() {
        repo.logOut()
    }

}