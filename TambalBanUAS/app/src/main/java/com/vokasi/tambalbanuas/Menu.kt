package com.vokasi.tambalbanuas

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {

    private var backPressedTime: Long = 0                                                              // ini cumma buat nyimpen lama waktu
    internal lateinit var backToast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var intent = intent
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        val sharedPreferences = getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
        sharedPreferences.apply {
            val namaa = getString("NAMA", "")
            tampilnama.setText("hai, " + namaa)                                                              // ini untuk menampilkan session setelah login
        }

        // ini fungsi untuk keluar/ LOGOUT
        kelogout.setOnClickListener{
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()
            val context = this
            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(context, MainActivity::class.java))
            finish()
        }

        bandekat.setOnClickListener {
            val context = this
            startActivity(Intent(context, ban_dekat::class.java))
        }

        bankontak.setOnClickListener {
            val context = this
            startActivity(Intent(context, ban_kontak::class.java))
        }

        bantips.setOnClickListener {
            val context = this
            startActivity(Intent(context, ban_tips::class.java))
        }

    }

    override fun onBackPressed() {                                                                  // ini emang fungsi bawaan dengan isi super.onBackPressed() untuk keluar dari aplikasi
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel()
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()
            editor.putString("STATUS","0")
            editor.apply()
            super.onBackPressed()                                                                   // ini BAWAAN kalau kita tekan back dengan kondisi 1 maka akan langsung keluar

        } else {
            backToast = Toast.makeText(baseContext, "Tekan lagi untuk keluar dari aplikasi", Toast.LENGTH_LONG)
            backToast.setGravity(Gravity.TOP,0,140)
            backToast.show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}
