package com.example.tutorial05.models

import com.example.tutorial05.models.validations.validationResult

class FormData (
    private var studentID:String,
    private var year:String,
    private var semester:String,
    private var agree:Boolean = false
    ) {
        fun validateStudentId(): validationResult {
            return if(studentID.isEmpty()){
                validationResult.Empty("Student ID is empty")
            }else if(!studentID.startsWith("IT")){
                validationResult.Invalid("Should be starting with IT")
            }else if(studentID.length<10){
                validationResult.Invalid("Student ID should have 10 characters")
            }else if(studentID.length>10){
                validationResult.Invalid("Student ID should have 10 characters")
            }else{
                validationResult.Valid
            }
        }
    fun validateYear(): validationResult {
        return if(year.isEmpty()){
            validationResult.Empty("Year is empty")
        }else{
            validationResult.Valid
        }
    }

    fun validateSemester(): validationResult {
        return if(semester.isEmpty()){
            validationResult.Empty("Semester is empty")
        }else{
            validationResult.Valid
        }
    }

    fun validateAgreement():validationResult{
        return if(!agree){
            validationResult.Invalid("You must agree for the terms and conditions")
        }else{
            validationResult.Valid
        }
    }

    }