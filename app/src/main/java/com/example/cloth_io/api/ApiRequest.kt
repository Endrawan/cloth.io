package com.example.cloth_io.api

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class ApiRequest(val context: Context) {

    private val TAG = "ApiRequest"
    private var queue:RequestQueue = Volley.newRequestQueue(context)
    private val gson = Gson()

    companion object {
        val base = "http://192.168.0.119:3000"
        val konveksi = "/mitra_konveksi"
        val toko = "/mitra_tokobaju"
        val pelanggan = "/pelanggan"
    }

    fun get(endpoint:String, actionSuccess:(ApiResponse) -> Unit, actionFailure: (VolleyError) -> Unit) {
        val request = StringRequest(
            Request.Method.GET, ApiRequest.base + endpoint,
            Response.Listener<String> { response ->
                Log.d(TAG, "Success: $response")
                val apiResponse = gson.fromJson<ApiResponse>(response, ApiResponse::class.java)
                actionSuccess(apiResponse)
            },
            Response.ErrorListener {
                Log.d(TAG, "Error: ${it.message}")
                actionFailure(it)
            })
        queue.add(request)
    }

    fun post(endpoint:String, bodyJson:String, actionSuccess: (String) -> Unit, actionFailure: (VolleyError) -> Unit) {
        val request = object : StringRequest(
            Request.Method.POST, ApiRequest.base + endpoint,
            Response.Listener<String> { response ->
                Log.d(TAG, "Success: $response")
                actionSuccess(response)
            },
            Response.ErrorListener {
                Log.d(TAG, "Error: ${it.message}")
                actionFailure(it)
            }) {
            override fun getBodyContentType(): String {
                return "application/json"
            }

            override fun getBody(): ByteArray {
                return bodyJson.toByteArray()
            }
        }
        queue.add(request)
    }

}