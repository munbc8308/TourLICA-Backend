package com.tourlica.backend.dto.request

import com.tourlica.backend.common.LanguageType
import com.tourlica.backend.entities.User
import java.util.*

data class TourRegisterRequest (
    var title: String,
    var description: String,
    var start: Date,
    var end: Date,
    var languages: List<LanguageType>,
    var push: Boolean,
    var sms: Boolean,
    var app: Boolean,
    var period: String,
    var user: User
)

