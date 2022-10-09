package com.example.demo.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class Customer(
    @Id
    val id: Long,
    val name: String
)
