package com.tourlica.backend.controllers

import com.tourlica.backend.dto.ApiResponse
import com.tourlica.backend.security.AdminAuthorize
import com.tourlica.backend.services.AdminService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@AdminAuthorize
@RestController
@RequestMapping("/admin")
class AdminController(private val adminService: AdminService) {

    @GetMapping("/members")
    fun getAllMembers() = ApiResponse.success(adminService.getUsers())


    @GetMapping("/admins")
    fun getAllAdmins() = ApiResponse.success(adminService.getAdmins())
}