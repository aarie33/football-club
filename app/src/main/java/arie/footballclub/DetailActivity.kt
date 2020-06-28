package arie.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MenuItem
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    companion object {
        val POS = "posisi_bundle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        val pos = intent.getIntExtra("idx",0)
        val txt_name = resources.getStringArray(R.array.club_name).get(pos)
        setTitle(txt_name)
        val view = DetailUI().setContentView(this)
        val image: ImageView = view.findViewById(DetailUI.imageId)
        image.setImageResource(resources.obtainTypedArray(R.array.club_image).getResourceId(pos,0))
        val name: TextView = view.findViewById(DetailUI.nameId)
        name.text = txt_name
        val desc: TextView = view.findViewById(DetailUI.descId)
        desc.text = resources.getStringArray(R.array.club_desc).get(pos)
    }

    class DetailUI : AnkoComponent<DetailActivity>{
        companion object {
            val imageId = 1
            val nameId = 2
            val descId = 3
        }
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            linearLayout(){
                lparams(matchParent, matchParent)
                orientation = LinearLayout.VERTICAL
                padding = dip(16)
                gravity = Gravity.CENTER_HORIZONTAL

                val imageV = imageView{
                    id = imageId
                }.lparams(width = dip(100), height = dip(100)){
                }
                val nameV = textView{
                    id = nameId
                    hint = "Nama club"
                    textSize = sp(16).toFloat()
                }.lparams(wrapContent, wrapContent){
                    gravity = Gravity.CENTER_HORIZONTAL
                    margin = dip(8)
                }
                val descV = textView{
                    id = descId
                    hint = "Description"
                }.lparams(matchParent, wrapContent)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home){
            finish()
            return false
        }

        return super.onOptionsItemSelected(item)
    }
}
