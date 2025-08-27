package com.example.soapysignal

import android.util.Patterns

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {

    private val accountHouseCode = "abc123"
    private val accountEmail = "juancruz@gmail.com"
    private val accountPassword = "123456"

    override fun validateInputs(houseCode: String, email: String, password: String) {
        when {
            houseCode.isEmpty() -> view.showError("Household code is required")
            houseCode.length < 3 -> view.showError("Household code must be at least 3 characters")
            email.isEmpty() -> view.showError("Email is required")
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> view.showError("Invalid email format")
            password.isEmpty() -> view.showError("Password is required")
            password.length < 6 -> view.showError("Password must be at least 6 characters")
            else -> validateLogin(houseCode, email, password)
        }
    }

    override fun validateLogin(houseCode: String, email: String, password: String) {
        if (houseCode == accountHouseCode &&
            email == accountEmail &&
            password == accountPassword) {
            view.showLoginSuccess()
        } else {
            view.showLoginFailed()
        }
    }

    override fun togglePasswordVisibility(isVisible: Boolean) {
        if (isVisible) {
            view.showPasswordHidden()
        } else {
            view.showPasswordVisible()
        }
    }

    override fun onSignUpClicked() {
        view.navigateToRegister()
    }
}
