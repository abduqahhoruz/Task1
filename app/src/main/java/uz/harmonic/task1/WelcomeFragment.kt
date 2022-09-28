package uz.harmonic.task1

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.harmonic.task1.databinding.FragmentWelcomeBinding

@AndroidEntryPoint
class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    private val binding: FragmentWelcomeBinding by viewBinding(FragmentWelcomeBinding::bind)

}