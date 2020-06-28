package com.example.museum.presentation.login

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.Observer
import com.dropit.ambassador.core.presentation.BaseActivity
import com.example.museum.R
import com.example.museum.data.model.LoginRequest
import com.example.museum.databinding.ActivityLoginBinding
import com.example.museum.presentation.certificates.CertificatesActivity
import com.example.museum.presentation.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {

    override fun getViewLayout(): Int = R.layout.activity_login

    override fun setObservers() {
        viewModel.isLogged.observe(this, Observer {
            if (it) startActivity(Intent(this, CertificatesActivity::class.java))
            else Toast.makeText(applicationContext, "Invalid login informations, try again!",Toast.LENGTH_LONG).show()
        })
    }

    override fun initView() {

        btLogin.setOnClickListener {
            if (loginInfoIsValid())
                viewModel.login(LoginRequest(
                    etUsername.text.toString(), etPassword.text.toString()
                ))
        }

        tvBtRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun loginInfoIsValid(): Boolean {
        if (etUsername.text.length < 5 && etPassword.text.length < 5) {
            Toast.makeText(
                applicationContext,
                "Username and password need to be at leas 5 characters long!",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }
        return true
    }
}
