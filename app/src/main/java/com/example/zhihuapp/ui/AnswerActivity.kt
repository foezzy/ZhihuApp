package com.example.zhihuapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.util.Log
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.allen.library.shape.ShapeRelativeLayout
import com.blankj.utilcode.util.ImageUtils
import com.bumptech.glide.Glide
import com.drake.brv.PageRefreshLayout
import com.drake.brv.utils.divider
import com.drake.brv.utils.linear
import com.drake.brv.utils.setup
import com.example.zhihuapp.utils.HtmlImageGetter
import com.example.zhihuapp.R
import com.example.zhihuapp.api.AnswerApi
import com.example.zhihuapp.bean.AnswerBean
import com.example.zhihuapp.bean.Data
import com.example.zhihuapp.config.ColorConfig
import com.hjq.http.EasyHttp
import com.hjq.http.listener.OnHttpListener
import org.jsoup.Jsoup
import org.jsoup.nodes.Document


class AnswerActivity : FragmentActivity() {

    val QUERY_PER_PAGE = 10
    lateinit var pageRefreshLayout: PageRefreshLayout

    var queryId = "618913967"

    companion object {
        fun launch(context: Context, qId: String) {
            var intent = Intent(context, AnswerActivity::class.java)
            intent.putExtra("qId", qId)
            startActivity(context, intent, null)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_anser)

        queryId = intent.extras?.getString("qId").toString()

        pageRefreshLayout = findViewById(R.id.pageLayout)
        pageRefreshLayout.onRefresh {
            getData()
        }
        initRv()
        getData()
    }

    private fun getData() {
        queryAnswer()
    }

    private fun queryAnswer() {
        EasyHttp.get(this)
            .api(
                AnswerApi().setAnswerId(queryId)
                    .setLimit(QUERY_PER_PAGE.toString())
                    .setOffset((pageRefreshLayout.index * QUERY_PER_PAGE).toString())
            )
            .request(object : OnHttpListener<AnswerBean?> {

                override fun onHttpSuccess(result: AnswerBean?) {
//                    findViewById<RecyclerView>(R.id.rv).bindingAdapter.models = result?.data
                    pageRefreshLayout.addData(result?.data)
                }

                override fun onHttpFail(e: java.lang.Exception?) {
                }
            })
    }

    private fun initRv() {
        findViewById<RecyclerView>(R.id.rv).linear().divider {
            setDivider(10, true)
        }.setup {
            addType<Data>(R.layout.item_anser)
            onBind {
                var data = getModel<Data>()

//                findView<RelativeLayout>(R.id.rlRoot).apply {
//                    setBackgroundColor(ColorConfig.getOrderReadingBgColor(adapterPosition))
//                }

                val rlRoot = findView<ShapeRelativeLayout>(R.id.rlRoot)
                rlRoot.apply {
                    shapeBuilder?.apply {
                        setShapeSolidColor(
                            ColorConfig.getOrderReadingBgColor(adapterPosition)
                        )
                        into(rlRoot)
                    }
                }

                var last = data.content
                val html = ("<html><body>" + last + "</body></html>")
                val doc: Document = Jsoup.parse(html)
                var stringBuffer = StringBuffer()
                doc.body().children().forEach {

                    var data = it.toString()

                    if (TextUtils.equals(it.tagName(), "figure")) {
                        var img = it.child(0).children().attr("src")
                        Log.d("EasyHttp", img)
                        stringBuffer.append("<img src=\"" + img + "\"/>")
                    } else {
                        if (it.childNodeSize() > 0) {
                            var text = it.childNode(0).toString()
                            stringBuffer.append(text)
                            stringBuffer.append("<br>")
                        }
                    }
                }


                var tv = findView<TextView>(R.id.textView)

                val imageGetter =
                    HtmlImageGetter(lifecycleScope, resources, Glide.with(context), tv)

                //替换多个<br>为一个<br>
                var lastText = stringBuffer.toString().replace(Regex("(\\s*<br>\\s*)+"), "<br>")
                tv.text = Html.fromHtml(
                    lastText,
                    imageGetter,
                    null
                ).trim()

            }
        }
    }


}