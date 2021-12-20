package com.example.logger.app.service

import com.example.logger.app.dto.MemberDto
import com.example.logger.app.dto.TeamDto
import com.example.logger.app.repository.MemberRepository
import com.example.logger.app.repository.TeamRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class Service(
    private val teamRepository: TeamRepository,
    private val memberRepository: MemberRepository
) {
    @Transactional(readOnly = true)
    fun findAllTeam(): List<TeamDto> = teamRepository.findAll()
        .map { TeamDto(it) }

    @Transactional(readOnly = true)
    fun findAllMember(): List<MemberDto> = memberRepository.findAll()
        .map { MemberDto(it) }
}