package com.example.soapysignal

import android.util.Patterns

class RegisterPresenter(private val view: RegisterContract.View) : RegisterContract.Presenter {

    override fun validateInputs(houseCode: String, fullName: String, email: String, password: String, confirmPassword: String, isAgreeChecked: Boolean) {
        when {
            houseCode.isEmpty() -> view.showHouseCodeError("Please enter your household code")
            fullName.isEmpty() -> view.showFullNameError("Please enter your full name")
            email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> view.showEmailError("Enter a valid email")
            password.length < 6 -> view.showPasswordError("Password must be at least 6 characters")
            confirmPassword != password -> view.showConfirmPasswordError("Passwords do not match")
            !isAgreeChecked -> view.showError("Please agree to the terms first")
            else -> view.showRegistrationSuccess()
        }
    }

    override fun onGoogleSignUp() {
        view.showGoogleSignUp()
    }

    override fun onSignInClick() {
        view.redirectToSignIn()
    }
}
