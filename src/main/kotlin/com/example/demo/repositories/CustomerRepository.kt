package com.example.demo.repositories

import com.example.demo.models.Customer
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface CustomerRepository : ReactiveCrudRepository<Customer, Long> {

    suspend fun findByName(name: String) : Mono<Customer>

    @Query("select c.* from customer c where c.name=?")
    suspend fun findByCustomerName(name: String) : Mono<Customer>
}