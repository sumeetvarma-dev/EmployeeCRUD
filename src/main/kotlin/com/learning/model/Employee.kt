package com.learning.model

import kotlinx.serialization.Serializable

@Serializable
data class Employee(val id:Int, var name:String, var address:String)

