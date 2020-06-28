package com.example.museum.presentation.register

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.Observer
import com.dropit.ambassador.core.presentation.BaseActivity
import com.example.museum.R
import com.example.museum.data.model.RegisterRequest
import com.example.museum.databinding.ActivityRegisterBinding
import com.example.museum.presentation.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity<RegisterViewModel, ActivityRegisterBinding>() {
    override fun getViewLayout(): Int = R.layout.activity_register

    override fun initView() {

        btRegister.setOnClickListener {
            if (registerInfoIsValied())
                viewModel.register(
                    RegisterRequest(
                        email = etEmail.text.toString(),
                        username = etUsername.text.toString(),
                        password = etPassword.text.toString()
                    )
                )
        }

        tvBtLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

    private fun registerInfoIsValied(): Boolean {
        if (etUsername.text.length < 5 && etPassword.text.length < 5) {
            Toast.makeText(
                applicationContext,
                "Username and password need to be at leas 5 characters long!",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        if (etEmail.text.matches(Regex(" ^(.+)@(.+)\$")).not()) {
            Toast.makeText(
                applicationContext,
                "Email is not okay",
                Toast.LENGTH_SHORT
            ).show(); return false
        }
        return true
    }

    override fun setObservers() {
        super.setObservers()

        viewModel.userCreated.observe(this, Observer {
            if (it) {
                Toast.makeText(
                    applicationContext,
                    "User registered, check you email to activate account",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            } else Toast.makeText(
                applicationContext,
                "Registration was unsuccessful",
                Toast.LENGTH_SHORT
            ).show()
        })

    }
}