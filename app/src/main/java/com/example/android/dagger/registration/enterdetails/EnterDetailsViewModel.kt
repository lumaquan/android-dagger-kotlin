package com.example.android.dagger.registration.enterdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

private const val MAX_LENGTH = 5

class EnterDetailsViewModel {

    private val _enterDetailsState = MutableLiveData<EnterDetailsViewState>()

    val enterDetailsState: LiveData<EnterDetailsViewState>
        get() = _enterDetailsState

    private val username_error = "Username has to be longer than 4 characters"
    val password_error = "Password has to be longer than 4 characters"

    fun validateInput(username: String, password: String) {
        when {
            username.length < MAX_LENGTH -> _enterDetailsState.value = EnterDetailsError(username_error)
            password.length < MAX_LENGTH -> _enterDetailsState.value = EnterDetailsError(password_error)
            else -> _enterDetailsState.value = EnterDetailsSuccess
        }
    }
}
