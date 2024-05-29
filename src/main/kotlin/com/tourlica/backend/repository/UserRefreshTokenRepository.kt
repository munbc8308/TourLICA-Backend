package com.tourlica.backend.repository

import com.tourlica.backend.entities.UserRefreshToken
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRefreshTokenRepository : JpaRepository<UserRefreshToken, UUID> {
    fun findByUserIdAndReissueCountLessThan(id: UUID, count: Long): UserRefreshToken?
}