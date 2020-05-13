package com.vokasi.tambalbanuas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.json.JSONObject

class SignIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val sharedPreferences = getSharedPreferences("CEK LOGIN", Context.MODE_PRIVATE)
        val stat=sharedPreferences.getString("STATUS","")

        if (stat=="1"){
            startActivity(Intent(this@SignIn,Menu::class.java))
            finish()
        }

        else {

            login_button.setOnClickListener{
                var username= login_email.text.toString()
                var password = login_password.text.toString()

                postkeserver(username,password)
            }
        }
    }

    fun postkeserver(username:String,password:String)
    {
        AndroidNetworking.post("http://192.168.43.31/tambalban/ceklogin.php")
            .addBodyParameter("gmail",username)
            .addBodyParameter("password",password)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{
                override fun onResponse(response: JSONObject) {

                    val jsonArray = response.getJSONArray("result")

                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("status"))
                        var statuslogin= jsonObject.optString("status")

                        Log.e("_kotlinnama", jsonObject.optString("nama"))

                        if (statuslogin=="1"){
                            val usernamee = username
                            val passwordd = password

                            val sharedPreferences= getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
                            val editor           = sharedPreferences.edit()

                            editor.putString("STATUS",statuslogin)
                            editor.putString("NAMA",jsonObject.optString("nama").toString())
                            editor.apply()

                            val intent = Intent(this@SignIn,Menu::class.java)
                            intent.putExtra("username", usernamee)
                            intent.putExtra("password", passwordd)
                            startActivity(intent)
                            finish()
                        }
                    }



                }

                override fun onError(error: ANError) { // handle error
                }

            })
    }
}
