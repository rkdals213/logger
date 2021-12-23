package com.example.logger.app.service

import com.example.logger.app.dto.MemberDto
import com.example.logger.app.dto.TeamDto
import com.example.logger.app.redis.TeamDtoPoint
import com.example.logger.app.repository.MemberRepository
import com.example.logger.app.repository.TeamRedisRepository
import com.example.logger.app.repository.TeamRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class Service(
    private val teamRepository: TeamRepository,
    private val memberRepository: MemberRepository,
    private val teamRedisRepository: TeamRedisRepository
) {
    @Transactional(readOnly = true)
    fun findAllTeam(): List<TeamDto> = teamRedisRepository.findById("key")
        .filter { it.available() }
        .map { it.teams }
        .orElseGet {
            val result = teamRepository.findAll()
                .map { TeamDto(it) }
            teamRedisRepository.save(TeamDtoPoint("key", 10, result))
            result
        }

    @Transactional(readOnly = true)
    fun findAllMember(): List<MemberDto> = memberRepository.findAll()
        .map { MemberDto(it) }
}