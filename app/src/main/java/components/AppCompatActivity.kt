package components

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.cloth_io.R
import com.example.cloth_io.models.Pelanggan
import com.google.gson.Gson

open class AppCompatActivity : AppCompatActivity() {

    val gson = Gson()
    protected lateinit var SP:SharedPreferences
    var user:Pelanggan? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SP = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        user = getUserFromSP()
    }

    override fun onResume() {
        super.onResume()
        user = getUserFromSP()
    }

    protected fun writeUserToSP(user: Pelanggan) {
        val editor = SP.edit()
        editor.putString("user", gson.toJson(user))
        editor.apply()
        this.user = getUserFromSP()
    }

    fun getUserFromSP(): Pelanggan? {
        val userJSON = SP.getString("user", null)
        return gson.fromJson<Pelanggan>(userJSON, Pelanggan::class.java)
    }

    fun logout() {
        val editor = SP.edit()
        editor.remove("user")
        editor.apply()
        this.user = getUserFromSP()
    }

    protected fun toast(msg:String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}