package com.example.zhihuapp.api;

import com.hjq.http.config.IRequestApi;
import com.hjq.http.config.IRequestServer;

import androidx.annotation.NonNull;

public final class HotApi implements IRequestServer, IRequestApi {

    @NonNull
    @Override
    public String getHost() {
        return "https://cors.mrju.cn/rss.mrju.cn/";
    }

    @NonNull
    @Override
    public String getApi() {
        return "zhihu/hotlist.json";
    }
}