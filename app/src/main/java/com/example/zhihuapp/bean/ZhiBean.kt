package com.example.zhihuapp.bean

data class ZhiBean(
    val `data`: List<ZhiData>,
    val display_first: Boolean,
    val display_num: Int,
    val fb_bill_main_rise: Int,
    val fresh_text: String,
    val paging: ZhiPaging
)

data class ZhiData(
    val attached_info: String,
    val card_id: String,
    val card_label: CardLabel,
    val children: List<Children>,
    val debut: Boolean,
    val detail_text: String,
    val id: String,
    val style_type: String,
    val target: Target,
    val trend: Int,
    val type: String
)

data class ZhiPaging(
    val is_end: Boolean,
    val is_start: Boolean,
    val next: String,
    val previous: String,
    val totals: Int
)

data class CardLabel(
    val icon: String,
    val night_icon: String,
    val type: String
)

data class Children(
    val thumbnail: String,
    val type: String
)

data class Target(
    val answer_count: Int,
    val author: ZhiAuthor,
    val bound_topic_ids: List<Int>,
    val comment_count: Int,
    val created: Int,
    val excerpt: String,
    val follower_count: Int,
    val id: Int,
    val is_following: Boolean,
    val title: String,
    val type: String,
    val url: String
)

data class ZhiAuthor(
    val avatar_url: String,
    val headline: String,
    val id: String,
    val name: String,
    val type: String,
    val url: String,
    val url_token: String,
    val user_type: String
)