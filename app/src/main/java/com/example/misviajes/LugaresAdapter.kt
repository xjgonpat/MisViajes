package com.example.misviajes

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.misviajes.databinding.LugarItemBinding

class LugaresAdapter(
    private val listaLugares: List<Lugar>,
    val lugarClickListener: (Lugar)->Unit):
 RecyclerView.Adapter<LugaresAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Utilizamos binding para inflar el adapter.

        val binding = LugarItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        //Devolvemos el viewHolder
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lugar = listaLugares[position]
        holder.bind(lugar)

        //Utilizamos la función lambda recibida como parámetro.
        holder.itemView.setOnClickListener{
            lugarClickListener(lugar)
        }
    }

    override fun getItemCount(): Int = listaLugares.size


    class ViewHolder(private val binding: LugarItemBinding): RecyclerView.ViewHolder(binding.root){
        //Creamos una función para la asignación del texto y la imagen
        // de cada una de las vistas del adapter.
        fun bind(lugar: Lugar)
        {
            binding.tvNombre.text=lugar.nombre
            Glide.with(binding.root.context)
                .load(lugar.foto)
                .into(binding.imgLugar)
        }
    }
}