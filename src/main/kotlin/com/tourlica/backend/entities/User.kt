package com.tourlica.backend.entities

import com.tourlica.backend.common.GenderType
import com.tourlica.backend.common.UserType
import com.tourlica.backend.dto.SignUpRequest
import com.tourlica.backend.dto.UserUpdateRequest
import jakarta.persistence.*

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDateTime
import java.util.*

@Entity
class User(
    @Column(nullable = false, scale = 20, unique = true)
    var email: String?,
    @Column(nullable = false)
    var password: String,
    var name: String? = null,
    @Enumerated(EnumType.STRING)
    val type: UserType = UserType.USER,
    @Column(nullable = false)
    var birthday: Date,
    @Enumerated(EnumType.STRING)
    var gender : GenderType = GenderType.MALE
    ): BaseTime() {

        override val regist_date: LocalDateTime = LocalDateTime.now()

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: UUID? = null


    companion object {
        fun from(request: SignUpRequest, encoder: PasswordEncoder) = User(
            email = request.email,
            password = encoder.encode(request.password),
            name = request.name,
            type = request.type,
            birthday = request.birthday,
            gender = request.gender
        )
    }

    fun update(newUser: UserUpdateRequest, encoder: PasswordEncoder) {
        this.password = newUser.newPassword
            ?.takeIf { it.isNotBlank() }
            ?.let { encoder.encode(it) }
            ?: this.password
        this.name = newUser.name
        this.email = newUser.email
    }
}