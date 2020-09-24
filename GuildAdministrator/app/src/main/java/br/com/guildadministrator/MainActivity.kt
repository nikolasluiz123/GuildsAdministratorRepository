package br.com.guildadministrator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureLoginButton()
    }

    private fun configureLoginButton() {
        button_login_main_activity.setOnClickListener { redirectToHome() }
    }

    private fun redirectToHome() = startActivity(Intent(this, HomeActivity::class.java))
}