package com.hanseltritama.multiplerecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hanseltritama.multiplerecyclerview.R
import com.hanseltritama.multiplerecyclerview.model.Characters

class HorizontalAdapter : RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>() {

    val items: List<Characters> = ArrayList()

    class HorizontalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val recyclerImage: ImageView = view.findViewById(R.id.rv_image_view)

        fun bind(data: Characters) {
            Glide.with(recyclerImage.context)
                .load(data.results[0].image)
                .into(recyclerImage)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HorizontalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_item, parent, false)
        return HorizontalViewHolder(view)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


}