package com.tourlica.backend.dto.request

import com.tourlica.backend.entities.TourRegisterInfo
import java.util.*

data class TourLocationAddRequest (
    val title: String,
    var mapX: String? = null,
    var mapY: String? = null,
    var addr1: String? = null,
    var addr2: String? = null,
    var contentId: String? = null,
    var contentTypeId: String? = null,
    var start: Date,
    var end: Date,
    var tell: String? = null,
    var tourRegistInfo: TourRegisterInfo
)
