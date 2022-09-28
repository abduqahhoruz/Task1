package uz.harmonic.task1.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.harmonic.task1.R
import uz.harmonic.task1.data.Pref
import uz.harmonic.task1.databinding.FragmentWelcomeBinding
import javax.inject.Inject


@AndroidEntryPoint
class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    private val binding: FragmentWelcomeBinding by viewBinding(FragmentWelcomeBinding::bind)
    private val viewModel: WelcomeViewModel by viewModels()

    @Inject
    lateinit var pref: Pref
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvWelcome.text = "Welcome ${pref.user?.firstName} ${pref.user?.lastName}"
        binding.btnExit.setOnClickListener {
            viewModel.logOut()
            findNavController().navigate(R.id.action_welcomeFragment_to_registerFragment)
        }
    }
}