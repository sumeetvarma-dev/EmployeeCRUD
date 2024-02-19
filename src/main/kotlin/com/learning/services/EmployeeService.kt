package com.learning.services

import com.learning.model.Employee
import java.util.UUID

class EmployeeService {

    private var employees = mutableListOf<Employee>(
        Employee(1,"Sumeet","Pune")
    )

    fun getEmployees():MutableList<Employee> = employees

    fun getEmployeeById(id:Int):Employee? = employees.firstOrNull { it.id == id }

    fun addEmployee(employee: Employee): Boolean = employees.add(employee)

    fun updateEmployee(id: Int,emp: Employee):Employee {
        val foundEmp = getEmployeeById(id)
        println("Employee Found::: $foundEmp")
        employees.remove(foundEmp)
        val empl = Employee(id,emp.name,emp.address)
        employees.add(
            empl
        )

        return empl
    }

    fun removeEmployee(id: Int): Boolean? {
        val foundEmp = getEmployeeById(id)
        val temp = foundEmp
        return employees.remove(foundEmp)

    }
}
