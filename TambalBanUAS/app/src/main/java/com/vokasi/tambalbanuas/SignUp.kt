package com.vokasi.tambalbanuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONArray

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signup_button.setOnClickListener {

            var nama = signup_nama.text.toString()
            var gmail = signup_email.text.toString()
            var password = signup_password.text.toString()


            postkeserver(nama, gmail, password)
            startActivity(Intent(this, SignIn::class.java))
        }

    }

    fun postkeserver(nama: String, gmail: String, password: String) {

        AndroidNetworking.post("http://192.168.43.31/tambalban/register.php")
            .addBodyParameter("nama", nama)
            .addBodyParameter("gmail", gmail)
            .addBodyParameter("password", password)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {


                }

                override fun onError(error: ANError) { // handle error
                }

            })


    }
}
