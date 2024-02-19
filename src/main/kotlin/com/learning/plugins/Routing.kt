package com.learning.plugins

import com.learning.routes.employeeRoutes
import com.learning.services.EmployeeService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        employeeRoutes()
    }


}
