package com.example.demo.configs

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration
import dev.miku.r2dbc.mysql.MySqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import java.time.Duration

@Configuration
class Database : AbstractR2dbcConfiguration() {

    override fun connectionFactory(): ConnectionFactory
            = MySqlConnectionFactory.from(
        MySqlConnectionConfiguration.builder()
            .host("localhost")
            .username("root")
            .port(3306)
            .password("root")
            .database("reactive")
            .connectTimeout(Duration.ofSeconds(3))
            .useServerPrepareStatement()
            .build()
    )

}