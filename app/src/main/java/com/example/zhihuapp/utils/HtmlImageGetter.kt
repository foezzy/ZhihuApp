package com.example.zhihuapp.utils

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.text.Html
import android.widget.TextView
import androidx.lifecycle.LifecycleCoroutineScope
import com.blankj.utilcode.util.ScreenUtils
import com.blankj.utilcode.util.SizeUtils
import com.bumptech.glide.RequestManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HtmlImageGetter(
    private val scope: LifecycleCoroutineScope,
    private val res: Resources,
    private val glide: RequestManager,
    private val htmlTextView: TextView
) : Html.ImageGetter {

    override fun getDrawable(url: String): Drawable {
        val holder = BitmapDrawablePlaceHolder(res, null)

        scope.launch(Dispatchers.IO) {
            runCatching {
                val bitmap = glide
                    .asBitmap()
                    .load(url)
                    .submit()
                    .get()

                val drawable = BitmapDrawable(res, bitmap)

                val scale =
                    drawable.intrinsicHeight / drawable.intrinsicWidth.toFloat() // This makes the image scale in size.

                //15f是textview的padding，10是setDivider的10dp
                val width =
                    ScreenUtils.getScreenWidth() - SizeUtils.dp2px(15f) * 2 - SizeUtils.dp2px(10f) * 2
                val height = (width * scale).toInt()

                drawable.setBounds(
                    0,
                    0,
                    width,
                    height
                )

                holder.setDrawable(drawable)
                holder.setBounds(
                    0,
                    0,
                    width,
                    height
                )

                withContext(Dispatchers.Main) { htmlTextView.text = htmlTextView.text }
            }
        }

        return holder
    }

    internal class BitmapDrawablePlaceHolder(res: Resources, bitmap: Bitmap?) :
        BitmapDrawable(res, bitmap) {
        private var drawable: Drawable? = null

        override fun draw(canvas: Canvas) {
            drawable?.run { draw(canvas) }
        }

        fun setDrawable(drawable: Drawable) {
            this.drawable = drawable
        }
    }
}