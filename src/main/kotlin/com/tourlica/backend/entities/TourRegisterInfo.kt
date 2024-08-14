package com.tourlica.backend.entities

import com.tourlica.backend.common.LanguageType
import com.tourlica.backend.dto.request.TourRegisterRequest
import jakarta.persistence.*
import java.util.*

@Entity
class TourRegisterInfo(
    @Column(nullable = false) var title: String,
    @Column(nullable = false) var description: String,
    @Column(nullable = false) var start: Date,
    @Column(nullable = false) var end: Date,
    @Column(nullable = false) var languages: List<LanguageType>,
    @Column(nullable = false) var push: Boolean,
    @Column(nullable = false) var sms: Boolean,
    @Column(nullable = false) var app: Boolean,
    @Column(nullable = false) var period: String,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn var user: User
): BaseTime() {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null

    companion object {
        fun from (request: TourRegisterRequest) = TourRegisterInfo(
            title = request.title,
            description = request.description,
            start = request.start,
            end = request.end,
            languages = request.languages,
            push = request.push,
            sms = request.sms,
            app = request.app,
            period = request.period,
            user = request.user
        )
    }
}
