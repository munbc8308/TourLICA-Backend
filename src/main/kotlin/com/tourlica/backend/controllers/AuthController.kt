package com.tourlica.backend.controllers

import com.tourlica.backend.dto.ApiResponse
import com.tourlica.backend.dto.SignInRequest
import com.tourlica.backend.dto.SignUpRequest
import com.tourlica.backend.services.SignService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class AuthController(private val signService: SignService) {

    @PostMapping("/sign-up")
    fun signUp(@RequestBody request: SignUpRequest) = ApiResponse.success(signService.registUser(request))

     @PostMapping("/sign-in")
    fun signIn(@RequestBody request: SignInRequest) = ApiResponse.success(signService.signIn(request))
}