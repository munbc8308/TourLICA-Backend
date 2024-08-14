package com.tourlica.backend.services

import com.tourlica.backend.common.UserType
import com.tourlica.backend.dto.response.UserInfoResponse
import com.tourlica.backend.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminService(private val userRepository: UserRepository) {
    @Transactional(readOnly = true)
    fun getUsers(): List<UserInfoResponse> = userRepository.findAllByType(UserType.USER).map(UserInfoResponse::from)

    @Transactional(readOnly = true)
    fun getAdmins(): List<UserInfoResponse> = userRepository.findAllByType(UserType.ADMIN).map(UserInfoResponse::from)

    @Transactional(readOnly = true)
    fun getGuides(): List<UserInfoResponse> = userRepository.findAllByType(UserType.GUIDE).map(UserInfoResponse::from)
}
