package br.com.guildadministrator

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_forgot_password.*


class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        configureButtonSendCode()
    }

    private fun configureButtonSendCode() {
        button_send_code_forgot_password_activity.setOnClickListener { onSendCode() }
    }

    private fun onSendCode() {
        MaterialAlertDialogBuilder(this, R.style.confirmation_dialog_theme)
            .setView(R.layout.dialog_send_code_forgot_password_verification)
            .setNegativeButton(R.string.label_cancel_dialog_send_code_forgot_password_verification) { dialog, _ ->  dialog.dismiss()}
            .setPositiveButton(R.string.label_verify_code_dialog_send_code_forgot_password_verification) { dialog, _ ->  dialog.dismiss()}
            .show()
    }

}