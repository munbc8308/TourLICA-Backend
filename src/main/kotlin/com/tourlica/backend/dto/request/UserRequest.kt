package com.tourlica.backend.dto.request

import com.tourlica.backend.common.GenderType
import com.tourlica.backend.common.UserType
import com.tourlica.backend.common.LanguageType
import java.util.*

data class SignUpRequest(
    var type: UserType,
    var password: String,
    var languages: List<LanguageType>,
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
    var languages: List<LanguageType>,
    val name: String? = null,
    var birthday: Date,
    var gender: GenderType
)
