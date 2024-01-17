package com.example.zhihuapp.bean

data class HotBean(
    val description: String,
    val home_page_url: String,
    val items: List<Item>,
    val language: String,
    val title: String,
    val version: String
)

data class Item(
    val authors: List<Author>,
    val content_html: String,
    val date_published: String,
    val id: String,
    val title: String,
    val url: String
)

data class Author(
    val name: String
)


