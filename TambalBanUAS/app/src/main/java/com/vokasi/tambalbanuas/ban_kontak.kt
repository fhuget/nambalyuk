package com.vokasi.tambalbanuas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_ban_kontak.*
import kotlinx.android.synthetic.main.list_layout.*
import org.json.JSONObject

class ban_kontak : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ban_kontak)

        kembali.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
            finish()
        }

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val users=ArrayList<User>()


        AndroidNetworking.get("https://pkmktambalban.000webhostapp.com/tambalban/bengkel.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)

                        Log.e("_kotlinTitle", jsonObject.optString("id_bengkel"))

                        var idB=jsonObject.optString("id_bengkel").toString()
                        var namaB=jsonObject.optString("nama_bengkel").toString()
                        var alamatB=jsonObject.optString("alamat_bengkel").toString()
                        var teleponB=jsonObject.optString("telepon_bengkel").toString()
                        var lokasiB=jsonObject.optString("lokasi_bengkel").toString()

                        users.add(User("$idB", "$namaB", "$alamatB", "$teleponB", "$lokasiB"))


                    }

                    val adapter= CustomAdapter(users)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }
}
