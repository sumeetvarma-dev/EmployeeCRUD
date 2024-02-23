package com.learning

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.describeSpec


class EmployeeTest : BehaviorSpec({

        given("I have 100 rupees in my account"){
            `when`("I request 20 rupees"){
                then("20 rupees should be withdraw."){

                }
            }
        }


})