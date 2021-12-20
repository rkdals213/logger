package com.example.logger.app.dto

import com.example.logger.app.entity.Member
import com.example.logger.app.entity.Team

class TeamDto(team: Team) {
    val teamId = team.id
    val teamName = team.name
    val members = team.members
        .members
        .map { MemberDto(it) }
}

class MemberDto(member: Member) {
    val memberId = member.id
    val memberName = member.name
}