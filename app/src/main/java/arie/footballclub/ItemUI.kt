package arie.footballclub

import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ItemUI : AnkoComponent<ViewGroup> {
    companion object {
        val nameId = 1
        val imageId = 2
    }
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        linearLayout{
            lparams(width= matchParent, height = wrapContent)
            padding = dip(16)
            orientation = LinearLayout.HORIZONTAL
            isClickable = true

            val image = imageView{
                id = imageId
                contentDescription = "Club Image"
            }.lparams(width = dip(50),height = dip(50))
            val name = textView{
                id = nameId
                hint = "Barcelona FC"
            }.lparams(wrapContent, wrapContent){
                margin = dip(10)
            }
        }
    }
}