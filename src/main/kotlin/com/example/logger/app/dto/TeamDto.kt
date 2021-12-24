package com.example.logger.app.dto

import com.example.logger.app.entity.Member
import com.example.logger.app.entity.Team

data class TeamDto(
    var teamId: Long = 0L,
    var teamName: String = "",
    var members: List<MemberDto> = listOf()
) {
    constructor(team: Team) : this(
        team.id,
        team.name,
        team.members.members.map { MemberDto(it) }
    )
}

data class MemberDto(
    var memberId: Long = 0L,
    var memberName: String = ""
) {
    constructor(member: Member) : this(
        member.id,
        member.name
    )
}