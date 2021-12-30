package com.example.logger

import com.example.logger.app.repository.TeamRedisRepository
import com.example.logger.app.service.Service
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.aop.aspectj.AspectJExpressionPointcut
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.lang.reflect.Method

@SpringBootTest
class LoggerApplicationTests @Autowired constructor(
    private val teamRedisRepository: TeamRedisRepository
) {

    var pointcut = AspectJExpressionPointcut()
    var helloMethod: Method? = null

    @BeforeEach
    @Throws(NoSuchMethodException::class)
    fun init() {
        helloMethod = Service::class.java.getMethod("findAllTeam")
    }


    @Test
    fun contextLoads() {
        pointcut.expression = "execution(* com.example.logger.app..*(..))"
        Assertions.assertThat(pointcut.matches(helloMethod!!, Service::class.java)).isTrue
    }

    @Test
    fun test1() {
        teamRedisRepository.findAll()
            .forEach { println(it) }
    }

}
