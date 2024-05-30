package com.tourlica.backend.controllers

import com.tourlica.backend.dto.ApiResponse
import com.tourlica.backend.dto.UserUpdateRequest
import com.tourlica.backend.entities.User
import com.tourlica.backend.security.UserAuthorize
import com.tourlica.backend.services.UserService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@UserAuthorize
@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getUserInfo(@AuthenticationPrincipal user: User) =
        ApiResponse.success(userService.getUserInfo(UUID.fromString(user.name)))


    @DeleteMapping
    fun deleteUser(@AuthenticationPrincipal user: User) =
        ApiResponse.success(userService.deleteMember(UUID.fromString(user.name)))

    @PutMapping
    fun updateUser(@AuthenticationPrincipal user: User, @RequestBody request: UserUpdateRequest) =
        ApiResponse.success(userService.updateUser(UUID.fromString(user.name), request))
}