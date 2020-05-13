package com.vokasi.tambalbanuas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val userList: ArrayList<User>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user: User=userList[position]
        holder?.idB?.text = user.id
        holder?.namaB?.text = user.nama
        holder?.alamatB?.text = user.alamat
        holder?.teleponB?.text = user.telepon
        holder?.lokasiB?.text = user.lokasi
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return  ViewHolder(v)

    }


    override fun getItemCount(): Int {

        return userList.size
    }



    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val idB = itemView.findViewById(R.id.idB) as TextView
        val namaB = itemView.findViewById(R.id.namaB) as TextView
        val alamatB = itemView.findViewById(R.id.alamatB) as TextView
        val teleponB = itemView.findViewById(R.id.teleponB) as TextView
        val lokasiB = itemView.findViewById(R.id.lokasiB) as TextView

    }

}