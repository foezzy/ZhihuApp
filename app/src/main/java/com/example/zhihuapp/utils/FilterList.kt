package com.example.zhihuapp.utils

object FilterList {

    val fliterList = arrayListOf<String>(
        "如何看待",
        "如何评价",
        "篮球",
        "梅西",
        "足球",
        "美网",
        "网球",
        "假如",
        "有哪个瞬间",
        "玄幻",
        "网文",
        "丧尸",
        "救赎",
        "情劫",
        "小说",
        "社死",
        "贴吧",
        "平行世界",
        "笑到",
        "讲一个",
        "封神",
        "短句",
        "体验",
        "故事",
        "你见过",
        "哪些句子",
        "吃货",
        "笑话",
        "开头",
        "细思极恐",
        "可不可以",
        "一个月",
        "为开头",
        "打脸",
        "有没有",
        "哪句话",
        "最能打动",
        "很喜欢",
        "一句话",
        "如果",
        "假如有",
        "有哪些",
        "细思极恐"
    )

    fun containFliter(content: String): Boolean {
        fliterList.forEach {
            if (content.contains(it)) {
                return true
            }
        }
        return false
    }

}