package com.example.logger.app.service

import com.example.logger.app.dto.MemberDto
import com.example.logger.app.dto.TeamDto
import com.example.logger.app.repository.MemberRepository
import com.example.logger.app.repository.TeamRepository
import org.springframework.stereotype.Service

@Service
class Service(
    private val teamRepository: TeamRepository,
    private val memberRepository: MemberRepository
) {
    fun findAllTeam(): List<TeamDto> = teamRepository.findAll().map { TeamDto(it) }

    fun findAllMember(): List<MemberDto> = memberRepository.findAll().map { MemberDto(it) }
}