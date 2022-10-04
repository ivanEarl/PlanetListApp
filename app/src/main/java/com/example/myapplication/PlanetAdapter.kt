package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.PlanetListBinding

class PlanetAdapter(
    var planets: List<Planet>
) : RecyclerView.Adapter<PlanetAdapter.TodoViewHolder>() {

    var onItemClick: ((Planet) -> Unit)? = null

    inner class TodoViewHolder(val binding: PlanetListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        val binding = PlanetListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanetAdapter.TodoViewHolder, position: Int) {
        val item = planets[position]
        holder.binding.apply {
            tvTitle.text = item.name
        }

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return planets.size
    }
}