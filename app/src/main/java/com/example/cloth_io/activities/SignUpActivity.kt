package com.example.cloth_io.activities

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.cloth_io.R
import com.example.cloth_io.R.layout.activity_sign_up
import com.example.cloth_io.api.ApiRequest
import com.example.cloth_io.fragments.main.ProfileFragment
import com.example.cloth_io.models.Pelanggan
import components.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject

class SignUpActivity : AppCompatActivity() {

    val pelanggan = Pelanggan()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_sign_up)

        val api = ApiRequest(this)
        Glide.with(this).load(R.drawable.icon).into(icon)

        signUp.setOnClickListener {
            pelanggan.email_pelanggan = email.text.toString()
            pelanggan.password = password.text.toString()
            pelanggan.nama_pelanggan = name.text.toString()
            pelanggan.alamat_pelanggan = address.text.toString()
            pelanggan.noTelp_pelanggan = phone.text.toString()
            pelanggan.noRek_pelanggan = account.text.toString()
            api.post(ApiRequest.pelanggan, gson.toJson(pelanggan), {
                val responseJSON = JSONObject(it)
                val response = responseJSON.getJSONObject("response")
                val id = response.getInt("insertId")
                pelanggan.id_pelanggan = id
                writeUserToSP(pelanggan)
                setResult(ProfileFragment.AUTH_SUCCESS)
                finish()
            }, {
                toast("Gagal!")
            })
        }
    }
}
