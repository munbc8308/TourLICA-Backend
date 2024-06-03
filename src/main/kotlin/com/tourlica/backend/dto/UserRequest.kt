package com.tourlica.backend.dto

import com.tourlica.backend.common.GenderType
import com.tourlica.backend.common.UserType
import java.util.*

data class SignUpRequest(
    var type: UserType,
    var password: String,
    val name: String? = null,
    val email: String? = null,
    var birthday: Date,
    var gender: GenderType
)

data class SignInRequest(
    val email: String,
    val password: String
)

data class UserUpdateRequest(
    var password: String,
    var newPassword: String? = null,
    val name: String? = null,
    val email: String? = null,
    var birthday: Date,
    var gender: GenderType
)