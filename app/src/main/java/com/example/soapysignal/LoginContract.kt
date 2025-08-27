package com.example.soapysignal

interface LoginContract {
    interface View {
        fun showError(message: String)
        fun showLoginSuccess()
        fun showLoginFailed()
        fun showPasswordVisible()
        fun showPasswordHidden()
        fun navigateToRegister()
    }

    interface Presenter {
        fun validateInputs(houseCode: String, email: String, password: String)
        fun validateLogin(houseCode: String, email: String, password: String)
        fun togglePasswordVisibility(isVisible: Boolean)
        fun onSignUpClicked()
    }
}
