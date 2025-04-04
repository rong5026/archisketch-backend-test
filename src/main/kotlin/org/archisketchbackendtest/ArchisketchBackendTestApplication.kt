package org.archisketchbackendtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class ArchisketchBackendTestApplication

fun main(args: Array<String>) {
	runApplication<ArchisketchBackendTestApplication>(*args)
}
