package uz.harmonic.task1.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.harmonic.task1.R
import uz.harmonic.task1.data.Pref
import uz.harmonic.task1.databinding.FragmentSplashBinding
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    @Inject
    lateinit var pref: Pref
    private val binding by viewBinding(FragmentSplashBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Looper.myLooper()?.let {
            Handler(it).postDelayed(Runnable {
           findNavController().navigate(whereToGo())
            }, 1200)
        }
    }

    private fun whereToGo(): Int {
        return if(pref.user==null){
            R.id.action_splashFragment_to_RegisterFragment
        } else{
            R.id.action_splashFragment_to_welcomeFragment
        }
    }
}