package com.vokasi.tambalbanuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ban_kontak.*
import kotlinx.android.synthetic.main.activity_ban_tips.*

class ban_tips : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ban_tips)

        next.setOnClickListener {
            val intent = Intent(this, ban_tips_2::class.java)
            startActivity(intent)
            finish()
        }
    }
}
