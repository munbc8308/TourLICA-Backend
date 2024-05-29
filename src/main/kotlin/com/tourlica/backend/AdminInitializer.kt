package com.tourlica.backend

import com.tourlica.backend.common.UserType
import com.tourlica.backend.entities.User
import com.tourlica.backend.repository.UserRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AdminInitializer(
    private val userRepository: UserRepository,
    private val encoder: PasswordEncoder
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        userRepository.save(User("admin", encoder.encode("admin"), "관리자", type = UserType.ADMIN))
    }
}