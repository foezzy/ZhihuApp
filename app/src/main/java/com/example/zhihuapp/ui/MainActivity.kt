package com.example.zhihuapp.ui

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.drake.brv.utils.bindingAdapter
import com.drake.brv.utils.divider
import com.drake.brv.utils.linear
import com.drake.brv.utils.models
import com.drake.brv.utils.setup
import com.drake.statelayout.StateLayout
import com.example.zhihuapp.R
import com.example.zhihuapp.api.ZhiApi
import com.example.zhihuapp.bean.ZhiBean
import com.example.zhihuapp.bean.ZhiData
import com.example.zhihuapp.utils.FilterList
import com.hjq.http.EasyHttp
import com.hjq.http.listener.OnHttpListener


class MainActivity : FragmentActivity() {

    //    lateinit var pageRefreshLayout: PageRefreshLayout
    lateinit var state: StateLayout
    lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)

        initView()

//        PageRefreshLayout.startIndex = 0
//        pageRefreshLayout.onRefresh {
//            getData()
//        }
        initRv()
        getData()
    }

    private fun initView() {
//        pageRefreshLayout = findViewById(R.id.pageLayout)
        state = findViewById(R.id.state)
        rv = findViewById(R.id.rv)
    }

    private fun getData() {
        if (rv.bindingAdapter.models == null || rv.bindingAdapter.models?.size == 0) state.showLoading()
        EasyHttp.get(this)
            .api(
                ZhiApi()
            )
            .request(object : OnHttpListener<ZhiBean?> {

                override fun onHttpSuccess(result: ZhiBean?) {
                    state.showContent()
                    if (result != null) {
                        rv.models =
                            result.data.filter { !FilterList.containFliter(it.target.title) }
                    }
//                    pageRefreshLayout.addData(result?.data)
                }

                override fun onHttpFail(e: java.lang.Exception?) {
                }
            })
    }

    private fun initRv() {
        rv.linear().divider {
            setDivider(10, true)
        }.setup {
            addType<ZhiData>(R.layout.item_hot)
            onBind {
                var item = getModel<ZhiData>()
                var tv = findView<TextView>(R.id.textView)
                tv.text = item.target.title
            }
            onClick(R.id.rlRoot) {
                var item = getModel<ZhiData>()
                val id = item.target.id.toString()
                if (id != null) {
                    AnswerActivity.launch(this@MainActivity, id)
                }
            }
        }

    }


}