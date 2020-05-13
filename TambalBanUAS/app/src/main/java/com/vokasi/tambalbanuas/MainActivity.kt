package com.vokasi.tambalbanuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val context: MainActivity = this

        kelogin.setOnClickListener {

            val intent = Intent(context, SignIn::class.java)
            startActivity(intent)
            finish()
        }

        kesignup.setOnClickListener {

            val intent = Intent(context, SignUp::class.java)
            startActivity(intent)
            finish()
        }
    }
}
