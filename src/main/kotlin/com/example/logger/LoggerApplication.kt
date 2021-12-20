package com.example.logger

import com.example.logger.app.entity.Member
import com.example.logger.app.entity.Team
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.annotation.PostConstruct
import javax.persistence.EntityManager

@SpringBootApplication
class LoggerApplication

fun main(args: Array<String>) {
    runApplication<LoggerApplication>(*args)
}

@Component
class InitService(
    private val init: Init
) {

    @PostConstruct
    fun init() {
        init.init()
    }

    companion object {
        @Component
        @Transactional
        class Init(private val entityManager: EntityManager) {
            fun init() {
                val team1 = Team("Team1")
                entityManager.persist(team1)

                val member = Member("member1", team1)
                team1.addMember(member)

                entityManager.persist(member)
            }
        }
    }
}