package com.tourlica.backend.dto

import com.tourlica.backend.common.UserType

data class SignUpRequest(
    var type: UserType,
    var password: String,
    val name: String? = null,
    val email: String? = null
)

data class SignInRequest(
    val email: String,
    val password: String
)

data class UserUpdateRequest(
    var password: String,
    var newPassword: String? = null,
    val name: String? = null,
    val email: String? = null
)