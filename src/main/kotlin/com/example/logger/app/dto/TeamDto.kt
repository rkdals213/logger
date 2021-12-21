package com.example.logger.app.dto

import com.example.logger.app.entity.Member
import com.example.logger.app.entity.Team
import java.io.Serializable

class TeamDto() : Serializable {
    var teamId = 0L
    var teamName = ""
    var members: List<MemberDto> = listOf()

    constructor(team: Team) : this() {
        this.teamId = team.id
        this.teamName = team.name
        this.members = team.members
            .members
            .map { MemberDto(it) }
    }

    override fun toString(): String {
        return "TeamDto(teamId=$teamId, teamName='$teamName', members=$members)"
    }
}

class MemberDto() : Serializable {
    var memberId = 0L
    var memberName = ""

    constructor(member: Member) : this() {
        memberId = member.id
        memberName = member.name
    }

    override fun toString(): String {
        return "MemberDto(memberId=$memberId, memberName='$memberName')"
    }
}