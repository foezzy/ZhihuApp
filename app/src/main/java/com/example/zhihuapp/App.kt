package com.example.zhihuapp

import android.app.Application
import android.content.Context
import com.drake.statelayout.StateConfig
import com.example.zhihuapp.config.ColorConfig
import com.example.zhihuapp.net.RequestHandler
import com.example.zhihuapp.net.RequestServer
import com.example.zhihuapp.utils.HeaderList
import com.hjq.http.EasyConfig
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.MaterialHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import okhttp3.Headers
import okhttp3.OkHttpClient


class App : Application() {

    companion object {
        private lateinit var mContext: Context
        fun getContext(): Context {
            return mContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
        initNet()
        initStateLayout()
        initBrv()
        ColorConfig.initColors()
    }

    private fun initStateLayout() {
        StateConfig.apply {
            loadingLayout = R.layout.layout_loading
        }
    }

    private fun initBrv() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout -> MaterialHeader(this) }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout -> ClassicsFooter(this) }
    }

    private fun initNet() {
        var server = RequestServer()
        EasyConfig.with(OkHttpClient()) // 是否打印日志
            .setLogEnabled(true) // 设置服务器配置
            .setServer(server) // 设置请求处理策略
            .setHandler(RequestHandler(this)) // 添加全局请求参数
            //.addParam("token", "6666666")
            // 添加全局请求头
            //.addHeader("time", "20191030")
            .into()
        EasyConfig.getInstance().addHeader(
            "user-agent",
            HeaderList.getHeader()
        )
    }

}