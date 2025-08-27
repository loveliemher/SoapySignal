package com.example.soapysignal


interface RegisterContract {
    interface View {
        fun showError(message: String)
        fun showHouseCodeError(message: String)
        fun showFullNameError(message: String)
        fun showEmailError(message: String)
        fun showPasswordError(message: String)
        fun showConfirmPasswordError(message: String)
        fun showRegistrationSuccess()
        fun showGoogleSignUp()
        fun redirectToSignIn()
    }

    interface Presenter {
        fun validateInputs(
            houseCode: String,
            fullName: String,
            email: String,
            password: String,
            confirmPassword: String,
            isAgreeChecked: Boolean
        )
        fun onGoogleSignUp()
        fun onSignInClick()
    }
}