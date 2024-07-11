package ru.korndev.nmediaandroidapp.dto

data class Post(
    val id:Long,
    val author: String,
    val publiched: String,
    val content: String,
    var like: Int,
    var shared: Int,
    val viewed: Int,
    var likedByMe: Boolean
)
