package com.tourlica.backend.entities

import com.tourlica.backend.dto.request.TourLocationAddRequest
import com.tourlica.backend.dto.request.TourRegisterRequest
import jakarta.persistence.*
import java.util.*

@Entity
class TourLocations (@Column(nullable = false) var title: String? = null,
                     @Column(nullable = false) var mapX: String? = null,
                     @Column(nullable = false) var mapY: String? = null,
                     @Column(nullable = false) var addr1: String? = null,
                     @Column(nullable = false) var addr2: String? = null,
                     @Column(nullable = false) var contentId: String? = null,
                     @Column(nullable = false) var contentTypeId: String? = null,
                     @Column(nullable = false) var start: Date,
                     @Column(nullable = false) var end: Date,
                     @Column(nullable = false) var tell: String? = null,
                     @ManyToOne(fetch = FetchType.LAZY) @JoinColumn var tourRegistInfo: TourRegisterInfo): BaseTime() {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null

    companion object {
        fun from (request: TourLocationAddRequest) = TourLocations(
            title = request.title,
            mapX = request.mapX,
            mapY = request.mapY,
            addr1 = request.addr1,
            addr2 = request.addr2,
            contentId = request.contentId,
            contentTypeId = request.contentTypeId,
            start = request.start,
            end = request.end,
            tell = request.tell,
            tourRegistInfo = request.tourRegistInfo
        )
    }
}
