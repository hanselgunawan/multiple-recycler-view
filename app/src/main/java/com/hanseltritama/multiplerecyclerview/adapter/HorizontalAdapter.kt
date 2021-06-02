package com.hanseltritama.multiplerecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hanseltritama.multiplerecyclerview.R
import com.hanseltritama.multiplerecyclerview.model.Result

class HorizontalAdapter : RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>() {

    private var items: MutableList<Result> = ArrayList()

    class HorizontalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val recyclerImage: ImageView = view.findViewById(R.id.rv_image_view)

        fun bind(data: Result) {
            Glide.with(recyclerImage.context)
                .load(data.image)
                .into(recyclerImage)
        }

    }

    fun setupData(data: ArrayList<Result>) {
        this.items = data
        notifyDataSetChanged()
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