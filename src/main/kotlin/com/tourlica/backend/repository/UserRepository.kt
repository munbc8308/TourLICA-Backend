package com.tourlica.backend.repository

import com.tourlica.backend.common.UserType
import com.tourlica.backend.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, UUID> {
    fun findByEmail(email: String): User?
    fun findAllByType(type: UserType): List<User>
}