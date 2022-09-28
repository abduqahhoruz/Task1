package uz.harmonic.task1.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.jakewharton.rxbinding4.widget.checkedChanges
import com.jakewharton.rxbinding4.widget.textChanges
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Function4
import uz.harmonic.task1.util.PhoneUtils
import uz.harmonic.task1.R
import uz.harmonic.task1.databinding.FragmentRegisterBinding
import uz.harmonic.task1.domen.User

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {
    private val binding: FragmentRegisterBinding by viewBinding(FragmentRegisterBinding::bind)
    private val cd: CompositeDisposable = CompositeDisposable()
    private val viewModel: RegisterViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        setupValidate()
    }

    private fun setupValidate() {
        val d = Observable.combineLatest(
            binding.etName.textChanges().skipInitialValue(),
            binding.etSureName.textChanges().skipInitialValue(),
            binding.etPhone.textChanges().skipInitialValue(),
            binding.chbTou.checkedChanges().skipInitialValue(),
            Function4(this::isValidate)
        ).doOnNext { binding.btnRegister.isEnabled = it }
            .subscribe()
        cd.add(d)
    }

    private fun isValidate(
        name: CharSequence,
        sureName: CharSequence,
        phone: CharSequence,
        isChecked: Boolean
    ): Boolean {
        if (name.isEmpty())
            binding.etName.error = "Ushbu maydonni to`ldirish shart"
        else
            binding.etName.error = null
        if (sureName.isEmpty())
            binding.etSureName.error = "Ushbu maydonni to`ldirish shart"
        else
            binding.etSureName.error = null
        if (phone.isEmpty() || phone.length < 17)
            binding.etPhone.error = "Telefon raqam to'liq kiritilmagan"
        else
            binding.etPhone.error = null
        if (!isChecked)
            binding.chbTou.error = "Foydalanish shartlarini ko'rib chiqing"
        else
            binding.chbTou.error = null
        return name.isNotEmpty() && phone.isNotEmpty() && sureName.isNotEmpty()
    }

    private fun setUpViews() {
        PhoneUtils.addMask(binding.etPhone)
        binding.btnRegister.setOnClickListener {
            val firstName = binding.etName.text.toString()
            val lastName = binding.etSureName.text.toString()
            val phone = binding.etPhone.text.toString()
            viewModel.register(
                User(System.currentTimeMillis(), firstName, lastName, phone)
            )
            val id = RegisterFragmentDirections.actionRegisterFragmentToWelcomeFragment()
            findNavController().navigate(id)
        }
    }


}