package com.example.tutorial05.models.validations

sealed class validationResult {
    data class Empty(val errorMessage: String) : validationResult()
    data class Invalid(val errorMessage: String) : validationResult()
    object Valid: validationResult()
}
