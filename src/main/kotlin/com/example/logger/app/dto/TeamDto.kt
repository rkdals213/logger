package com.example.logger.app.dto

import com.example.logger.app.entity.Member
import com.example.logger.app.entity.Team
import java.io.Serializable

data class TeamDto(
    var teamId: Long = 0L,
    var teamName: String = "",
    var members: List<MemberDto> = listOf()
) : Serializable {
    constructor(team: Team) : this(
        team.id,
        team.name,
        team.members.members.map { MemberDto(it) }
    )
}

data class MemberDto(
    var memberId: Long = 0L,
    var memberName: String = ""
) : Serializable {
    constructor(member: Member) : this(
        member.id,
        member.name
    )
}