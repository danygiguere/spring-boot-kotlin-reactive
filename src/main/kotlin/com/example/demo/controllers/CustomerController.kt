package com.example.demo.controllers

import com.example.demo.models.Customer
import com.example.demo.repositories.CustomerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/customers")
class CustomerController(val customerRepository: CustomerRepository) {

//    @GetMapping
//    suspend fun getAllCustomer() : String = "customers"

//    @GetMapping
//    suspend fun getAllCustomer() : Flux<Customer> = customerRepository.findAll()

    @GetMapping
    suspend fun getAllCustomer() : Flow<Customer> = customerRepository.findAll().asFlow()

    @GetMapping("/{id}")
    suspend fun getOneCustomer(@PathVariable id: Long) : Customer? = customerRepository.findById(id).awaitFirstOrNull()

    @GetMapping("/name/{name}")
    suspend fun getCustomerByName(@PathVariable name: String) : Customer? = customerRepository.findByName(name).awaitFirstOrNull()

    @GetMapping("/cname/{name}")
    suspend fun getCustomerByCustomerName(@PathVariable name: String) : Customer? = customerRepository.findByCustomerName(name).awaitFirstOrNull()


}