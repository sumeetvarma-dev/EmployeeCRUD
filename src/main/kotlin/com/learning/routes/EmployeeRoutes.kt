package com.learning.routes

import com.learning.dto.EmployeeDto
import com.learning.dto.toEmployee
import com.learning.model.Employee
import com.learning.services.EmployeeService
import com.learning.validators.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.employeeRoutes(){
    val employeeService: EmployeeService = EmployeeService()
    route("/employee"){
        get {
            println("Fetching all Employees")
            call.respond(employeeService.getEmployees())
        }
        get("/{id}") {
            var id: String? = call.parameters["id"]
            if (!id.checkIfIdIsOnlyDigit()) return@get call.respondText("Missing Id", status = HttpStatusCode.BadRequest)
            val employee = id?.toIntOrNull()?.let { it1 -> employeeService.getEmployeeById(it1) }
            call.respond(employee?: "Employee not found")
        }

        post {
            val employee = call.receive<EmployeeDto>()
            if(!employee.name.mustBeAtLeast3Characters()) return@post call.respondText("Name must be at least 3 character long", status = HttpStatusCode.BadRequest)
            if(!employee.name.mustBeLessThan20Characters()) return@post call.respondText("Name must be at least 3 character long", status = HttpStatusCode.BadRequest)
            if(!employee.address.mustBeAtLeast3Characters()) return@post call.respondText("Address must be at least 3 character long", status = HttpStatusCode.BadRequest)

            val msg = employeeService.addEmployee(employee.toEmployee()) ?: "Employee already exists Or can't add it"
            call.respondText("Employee Added:: $msg",status = HttpStatusCode.Created)
        }
        put("/{id}") {
            val id = call.parameters["id"]
            if (!id.checkIfIdIsOnlyDigit()) return@put call.respondText("Missing Id", status = HttpStatusCode.BadRequest)
            val employee = call.receive<EmployeeDto>()
            if(!employee.name.mustBeAtLeast3Characters()) return@put call.respondText("Name must be at least 3 character long", status = HttpStatusCode.BadRequest)
            if(!employee.name.mustBeLessThan20Characters()) return@put call.respondText("Name should not be more than 20 character long", status = HttpStatusCode.BadRequest)
            if(!employee.address.mustBeAtLeast3Characters()) return@put call.respondText("Address must be at least 3 character long", status = HttpStatusCode.BadRequest)

            val emp = id?.toIntOrNull()?.let { it -> employeeService.updateEmployee(it,employee.toEmployee()) }
            call.respond(emp?:"Update Failed")
        }

        delete("/{id}") {
            val id =  call.parameters["id"]
            if (!id.checkIfIdIsOnlyDigit()) return@delete call.respondText("Missing Id", status = HttpStatusCode.BadRequest)
            val emp = id?.toIntOrNull()?.let { it -> employeeService.removeEmployee(it) }

            call.respondText(if(emp == true) "Employee Deleted" else "Employee Not Found", status = HttpStatusCode.Accepted)
        }
    }
}