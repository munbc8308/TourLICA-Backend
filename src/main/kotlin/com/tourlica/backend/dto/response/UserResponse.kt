package com.tourlica.backend.dto.response

import com.tourlica.backend.common.GenderType
import com.tourlica.backend.common.LanguageType
import com.tourlica.backend.common.UserType
import com.tourlica.backend.entities.User
import java.util.*

data class SignUpResponse(
    val id: UUID,
    val email: String?,
    val name: String?,
    val languages: List<LanguageType>?,
    ) {
    companion object {
        fun from(user: User) = SignUpResponse(
            id = user.id!!,
            email = user.email,
            languages = user.languages,
            name = user.name
        )
    }
}

data class SignInResponse(

    val name: String?,
    val type: UserType,
    val accessToken: String,
    val refreshToken: String
)

data class UserUpdateResponse(
    val result: Boolean,
    val name: String?,
) {
    companion object {
        fun of(result: Boolean, user: User) = UserUpdateResponse(
            result = result,
            name = user.name

        )
    }
}

data class UserInfoResponse(
    val id: UUID,
    val email: String?,
    val name: String?,
    val languages: List<LanguageType>,
    val type: UserType,
    val birthday: Date,
    var gender: GenderType,
    var phone: String? = null,
    ) {
    companion object {
        fun from(user: User) = UserInfoResponse(
            id = user.id!!,
            email = user.email,
            name = user.name,
            languages = user.languages,
            type = user.type,
            birthday = user.birthday,
            gender = user.gender,
            phone = user.phone,
        )
    }
}

data class UserDeleteResponse(
    val result: Boolean
)
