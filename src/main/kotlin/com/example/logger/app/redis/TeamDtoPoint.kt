package com.example.logger.app.redis

import com.example.logger.app.dto.TeamDto
import org.springframework.data.redis.core.RedisHash
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Id

@RedisHash("point")
class TeamDtoPoint(
    @Id
    val id: String,
    var amount: Long = 5,
    var teams: List<TeamDto> = listOf()
) : Serializable {
    var refreshTime = LocalDateTime.now()
        .plusSeconds(amount)!!
        private set

    fun available() = LocalDateTime.now()
        .isBefore(this.refreshTime)

    fun refresh(amount: Long, teams: List<TeamDto>) {
        this.refreshTime = LocalDateTime.now()
            .plusSeconds(amount)
        this.amount = amount
        this.teams = teams
    }

    override fun toString(): String {
        return "TeamDtoPoint(id='$id', amount=$amount, teams=$teams, refreshTime=$refreshTime)"
    }
}