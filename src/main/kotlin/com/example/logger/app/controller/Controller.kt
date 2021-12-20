package com.example.logger.app.controller

import com.example.logger.app.service.Service
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
    private val service: Service
) {
    @GetMapping("/team")
    fun findAllTeam(): ResponseEntity<Any> = ResponseEntity.ok(service.findAllTeam())

    @GetMapping("/member")
    fun findAllMember(): ResponseEntity<Any> = ResponseEntity.ok(service.findAllMember())
}