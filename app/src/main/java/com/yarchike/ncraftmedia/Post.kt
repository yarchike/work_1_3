package com.yarchike.ncraftmedia

class Post(
    val id: Int,
    val data: Long,
    val autor: String,
    val postText: String,
    val like: Int = 0,
    val comments: Int = 0,
    val share: Int = 0,
    val isLike: Boolean,
    val isComment: Boolean,
    val isShare: Boolean
) {


}