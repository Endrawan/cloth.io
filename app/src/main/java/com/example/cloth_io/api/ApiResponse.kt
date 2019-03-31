package com.example.cloth_io.api

data class ApiResponse (
    var error:String? = null,
    var response:List<*>? = null
)