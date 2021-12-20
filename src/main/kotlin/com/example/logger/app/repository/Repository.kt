package com.example.logger.app.repository

import com.example.logger.app.entity.Member
import com.example.logger.app.entity.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository: JpaRepository<Team, Long>

interface MemberRepository: JpaRepository<Member, Long>