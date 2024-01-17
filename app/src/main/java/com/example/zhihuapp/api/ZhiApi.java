package com.example.zhihuapp.api;

import com.hjq.http.config.IRequestApi;
import com.hjq.http.config.IRequestServer;

import androidx.annotation.NonNull;

public final class ZhiApi implements IRequestServer, IRequestApi {

    @NonNull
    @Override
    public String getHost() {
        return "https://api.zhihu.com/";
    }

    @NonNull
    @Override
    public String getApi() {
        return "topstory/hot-lists/total";
    }
}