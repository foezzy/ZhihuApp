package com.example.zhihuapp.net;

import com.hjq.http.config.IRequestServer;

public class RequestServer implements IRequestServer {

    @Override
    public String getHost() {
        return "https://www.baidu.com/";
    }

}

