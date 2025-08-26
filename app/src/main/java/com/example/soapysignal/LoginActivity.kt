package com.example.soapysignal

import android.app.Activity
import android.os.Bundle
import android.text.InputType
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : Activity(), LoginContract.View {

    private lateinit var etHouseCode: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etHouseCode = findViewById(R.id.etHouseCode)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        presenter = LoginPresenter(this)

        btnLogin.setOnClickListener {
            presenter.validateInputs(
                etHouseCode.text.toString().trim(),
                etEmail.text.toString().trim(),
                etPassword.text.toString().trim()
            )
        }

        etPassword.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = 2
                if (event.rawX >= (etPassword.right - etPassword.compoundDrawables[drawableEnd].bounds.width())) {
                    val isVisible = etPassword.inputType !=
                            (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                    presenter.togglePasswordVisibility(isVisible)
                    return@setOnTouchListener true
                }
            }
            false
        }
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoginSuccess() {
        Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
    }

    override fun showLoginFailed() {
        Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
    }

    override fun showPasswordVisible() {
        etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        etPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eyeopen, 0)
        etPassword.setSelection(etPassword.text.length)
    }

    override fun showPasswordHidden() {
        etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        etPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eyeclose, 0)
        etPassword.setSelection(etPassword.text.length)
    }

}
