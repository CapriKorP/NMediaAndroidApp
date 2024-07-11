package ru.korndev.nmediaandroidapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.korndev.nmediaandroidapp.R
import ru.korndev.nmediaandroidapp.databinding.ActivityMainBinding
import ru.korndev.nmediaandroidapp.dto.Post
import ru.korndev.nmediaandroidapp.utils.converter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            ActivityMainBinding.inflate(layoutInflater) //генерация класса ActivityMainBinding,
        setContentView(binding.root)

        var post = Post(
            1,
            "Netology",
            "1 января 2024 в 00:01",
            "Привет Котлин! Это мой первый пост)))",
            15,
            10000000,
            1000,
            true
        )

        with(binding) {
            tvAuthor.text = post.author
            tvPublished.text = post.publiched
            tvContent.text = post.content
            tvLike.text = converter(post.like)
            tvShared.text = converter(post.shared)
            tvViewed.text = converter(post.viewed)
            if (post.likedByMe) {
                ibLike?.setImageResource(R.drawable.like_red)
            }

            ibLike?.setOnClickListener {
                println("clicked Like")
                post.likedByMe = !post.likedByMe
                tvLike.text = converter(if(!post.likedByMe) post.like++ else post.like--)
                ibLike.setImageResource(
                    if (post.likedByMe) R.drawable.like_red else R.drawable.like_black
                )
            }

            ibShare?.setOnClickListener {
                println("clicked Share")
                post.shared = post.shared + 1
                tvShared.text = converter(post.shared)
            }
        }
    }


}
