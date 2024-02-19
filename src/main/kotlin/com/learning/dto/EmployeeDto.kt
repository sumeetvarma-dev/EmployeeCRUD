package com.learning.dto

import com.learning.model.Employee
import kotlinx.serialization.Serializable

@Serializable
class EmployeeDto(val name:String,val address:String)

fun EmployeeDto.toEmployee():Employee{
    return Employee((2..2000).random().toInt(), this.name,this.address)
}

