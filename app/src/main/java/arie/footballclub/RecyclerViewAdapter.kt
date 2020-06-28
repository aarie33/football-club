package arie.footballclub

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.bundleOf

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>)
    : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        return MyViewHolder(ItemUI().createView(AnkoContext.create(context, parent)))
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.bindItem(items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val image: ImageView
        private val name: TextView
        init {
            image = itemView.findViewById(ItemUI.imageId)
            name = itemView.findViewById(ItemUI.nameId)
        }

        fun bindItem(items: Item, position: Int) {
            items.image?.let { Picasso.get().load(it).into(image) }
            name.text = items.nama
            itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("idx", position)
                startActivity(context,intent, bundleOf("idx" to position))
//
//                startActivity(intentFor<DetailActivity>(
//                        "idx" to "${position}")
            }
        }
    }
}