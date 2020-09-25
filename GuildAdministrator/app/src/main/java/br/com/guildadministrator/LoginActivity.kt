package br.com.guildadministrator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        configureLoginButton()
        configureForgotPasswordButton()
    }

    private fun configureForgotPasswordButton() {
        text_button_forgot_password_login_activity.setOnClickListener { redirectToForgotPassword() }
    }

    private fun redirectToForgotPassword() {
        startActivity(Intent(this, ForgotPasswordActivity::class.java))
    }

    private fun configureLoginButton() {
        button_login_main_activity.setOnClickListener { redirectToHome() }
    }

    private fun redirectToHome() = startActivity(Intent(this, HomeActivity::class.java))
}