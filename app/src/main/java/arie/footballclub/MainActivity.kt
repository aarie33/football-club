package arie.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getData()
        val rview = MainActivityUI().setContentView(this)
        val rv: RecyclerView = rview.findViewById(MainActivityUI.rvId)
        rv.adapter = RecyclerViewAdapter(this, items)
    }
    private fun getData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i], image.getResourceId(i,0)))
        }
        Log.d("Items", items.toString())
        image.recycle()
    }
    class MainActivityUI : AnkoComponent<MainActivity>{
        companion object {
            val rvId = 1
        }
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

            linearLayout{
                lparams(matchParent, matchParent)
                orientation = LinearLayout.VERTICAL

                val rview = recyclerView {
                    id = rvId
                    lparams(matchParent, matchParent)
                    layoutManager = LinearLayoutManager(context)
                }
            }
        }

    }
}
