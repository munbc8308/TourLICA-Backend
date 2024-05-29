package com.tourlica.backend.services

import com.tourlica.backend.dto.UserInfoResponse
import com.tourlica.backend.dto.UserUpdateResponse
import com.tourlica.backend.dto.UserUpdateRequest
import com.tourlica.backend.repository.UserRepository
import com.tourlica.backend.dto.UserDeleteResponse
import com.tourlica.backend.utils.findByIdOrThrow
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
    private val encoder: PasswordEncoder
) {
    @Transactional(readOnly = true)
    fun getMemberInfo(id: UUID) = UserInfoResponse.from(userRepository.findByIdOrThrow(id, "존재하지 않는 회원입니다."))

    @Transactional
    fun deleteMember(id: UUID): UserDeleteResponse {
        if (!userRepository.existsById(id)) return UserDeleteResponse(false)
        userRepository.deleteById(id)
        return UserDeleteResponse(true)
    }

    @Transactional
    fun updateMember(id: UUID, request: UserUpdateRequest): UserUpdateResponse {
        val user = userRepository.findByIdOrNull(id)?.takeIf { encoder.matches(request.password, it.password) }
            ?: throw IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.")
        user.update(request, encoder)
        return UserUpdateResponse.of(true, user)
    }
}