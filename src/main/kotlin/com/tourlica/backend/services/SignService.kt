package com.tourlica.backend.services

import com.tourlica.backend.dto.SignInResponse
import com.tourlica.backend.dto.SignInRequest
import com.tourlica.backend.dto.SignUpRequest
import com.tourlica.backend.dto.SignUpResponse
import com.tourlica.backend.entities.UserRefreshToken
import com.tourlica.backend.repository.UserRefreshTokenRepository
import com.tourlica.backend.repository.UserRepository
import com.tourlica.backend.security.jwt.TokenProvider
import com.tourlica.backend.utils.flushOrThrow
import com.tourlica.backend.entities.User
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignService(
    private val userRepository: UserRepository,
    private val userRefreshTokenRepository: UserRefreshTokenRepository,
    private val tokenProvider: TokenProvider,
    private val encoder: PasswordEncoder
) {
    @Transactional
    fun registUser(request: SignUpRequest) = SignUpResponse.from(
        userRepository.flushOrThrow(IllegalArgumentException("이미 사용중인 아이디입니다.")) { save(User.from(request, encoder)) }
    )

    @Transactional
    fun signIn(request: SignInRequest): SignInResponse {
        val user = userRepository.findByEmail(request.email)
            ?.takeIf { encoder.matches(request.password, it.password) } ?: throw IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.")
        val accessToken = tokenProvider.createAccessToken("${user.id}:${user.type}")
        val refreshToken = tokenProvider.createRefreshToken()
        userRefreshTokenRepository.findByIdOrNull(user.id)?.updateRefreshToken(refreshToken)
            ?: userRefreshTokenRepository.save(UserRefreshToken(user, refreshToken))
        return SignInResponse(user.name, user.type, accessToken, refreshToken)
    }
}