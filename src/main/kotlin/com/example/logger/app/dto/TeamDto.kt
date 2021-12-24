package com.example.logger.app.dto

import com.example.logger.app.entity.Member
import com.example.logger.app.entity.Team

data class TeamDto(
    val teamId: Long = 0L,
    val teamName: String = "",
    val members: List<MemberDto> = listOf()
) {
    constructor(team: Team) : this(
        team.id,
        team.name,
        team.members.members.map { MemberDto(it) }
    )
}

data class MemberDto(
    val memberId: Long = 0L,
    val memberName: String = ""
) {
    constructor(member: Member) : this(
        member.id,
        member.name
    )
}