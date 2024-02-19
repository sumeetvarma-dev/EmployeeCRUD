package com.learning.routes

import com.learning.dto.EmployeeDto
import com.learning.dto.toEmployee
import com.learning.model.Employee
import com.learning.services.EmployeeService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.employeeRoutes(){
    val employeeService: EmployeeService = EmployeeService()
    route("/employee"){
        get {

            call.respond(employeeService.getEmployees())
        }
        get("/{id}") {
            var id: String? = call.parameters["id"]
            if (!checkIfIdIsOnlyDigit(id)) return@get call.respondText("Missing Id", status = HttpStatusCode.BadRequest)
            val employee = id?.toIntOrNull()?.let { it1 -> employeeService.getEmployeeById(it1) }
            call.respond(employee?: "Employee not found")
        }

        post {
            val employee = call.receive<EmployeeDto>()
            val msg = employeeService.addEmployee(employee.toEmployee()) ?: "Employee already exists Or can't add it"
            call.respondText("Employee Added:: $msg",status = HttpStatusCode.Created)
        }
        put("/{id}") {
            val id = call.parameters["id"]
            if (!checkIfIdIsOnlyDigit(id)) return@put call.respondText("Missing Id", status = HttpStatusCode.BadRequest)
            val employee = call.receive<EmployeeDto>()
            val emp = id?.toIntOrNull()?.let { it -> employeeService.updateEmployee(it,employee.toEmployee()) }
            call.respond(emp?:"Update Failed")
        }

        delete("/{id}") {
            val id =  call.parameters["id"]
            if (!checkIfIdIsOnlyDigit(id)) return@delete call.respondText("Missing Id", status = HttpStatusCode.BadRequest)
            val emp = id?.toIntOrNull()?.let { it -> employeeService.removeEmployee(it) }

            call.respondText(if(emp == true) "Employee Deleted" else "Employee Not Found", status = HttpStatusCode.Accepted)
        }
    }
}

private fun checkIfIdIsOnlyDigit(id: String?): Boolean {
    val num = id?.toIntOrNull()
    return when(num){
        null -> false
        else -> true
    }


}