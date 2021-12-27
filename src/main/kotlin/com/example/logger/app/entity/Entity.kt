package com.example.logger.app.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
abstract class BaseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
) {
    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    val updatedAt: LocalDateTime = LocalDateTime.now()

    private var deleted: Boolean = false

    fun delete() {
        deleted = true
    }
}

@Entity
class Team(
    val name: String,

    val members: Members = Members(),

    id: Long = 0L,
) : BaseEntity(id) {
    fun addMember(member: Member) {
        members.addMember(member)
    }
}

@Embeddable
class Members(
    @OneToMany
    val members: MutableList<Member> = mutableListOf()
) {
    fun addMember(member: Member) {
        members.add(member)
    }
}

@Entity
class Member(
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    val team: Team,

    id: Long = 0L,
) : BaseEntity(id)
