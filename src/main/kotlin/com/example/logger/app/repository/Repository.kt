package com.example.logger.app.repository

import com.example.logger.app.entity.Member
import com.example.logger.app.entity.Team
import com.example.logger.app.redis.TeamDtoPoint
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface TeamRepository: JpaRepository<Team, Long>

interface MemberRepository: JpaRepository<Member, Long>

interface TeamRedisRepository: CrudRepository<TeamDtoPoint, String>