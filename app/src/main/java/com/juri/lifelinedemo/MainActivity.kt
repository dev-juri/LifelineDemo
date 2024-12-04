package com.juri.lifelinedemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.juri.lifelinedemo.data.LoginBody
import com.juri.lifelinedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
        crossinline bindingInflater: (LayoutInflater) -> T
    ) = lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater.invoke(layoutInflater)
    }

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        observeState()

        binding.submitButton.setOnClickListener {

            val email = binding.emailLayout.editText?.text.toString().trim().lowercase()
            val name = binding.nameLayout.editText?.text.toString().trim()
            val password = binding.passwordLayout.editText?.text.toString().trim()

            loginViewModel.loginUser(LoginBody(email, name, password))
        }
    }

    private fun observeState() {
        loginViewModel.result.observe(this) { res ->
            binding.result.visibility = View.VISIBLE

            binding.result.text = res.toString()
        }
    }
}