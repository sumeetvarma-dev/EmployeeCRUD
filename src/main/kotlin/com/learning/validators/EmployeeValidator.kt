package com.learning.validators

import com.learning.dto.EmployeeDto

fun String?.checkIfIdIsOnlyDigit(): Boolean {
    val num = this?.toIntOrNull()
    return when(num){
        null -> false
        else -> true
    }
}

fun String.mustBeAtLeast3Characters(): Boolean  = this.length >= 3

fun String.mustBeLessThan20Characters(): Boolean = this.length <= 20