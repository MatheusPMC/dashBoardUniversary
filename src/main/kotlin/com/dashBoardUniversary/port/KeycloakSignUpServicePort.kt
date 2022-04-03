package com.dashBoardUniversary.port

import com.dashBoardUniversary.model.UserLogin

interface KeycloakSignUpServicePort {
    fun signUp(user: UserLogin): UserLogin
}