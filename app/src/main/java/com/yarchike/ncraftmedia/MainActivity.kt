package com.yarchike.ncraftmedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val post = Post(
            12, 1594585699570, "Мартынов Я.В.",
            "10 февраля, среда\n" +
                    "\n" +
                    "Львам так надоело терять людей! \n" +
                    "Им нужен тот, кто придет в их жизнь \n" +
                    "и скажет: 'Хочешь, не хочешь, а я остаюсь", 15,
            0, 5, isLike = true, isComment = false, isShare = false
        )
        init(post)


    }

    fun istruth(post: Post) {
        if (post.isLike) {
            likeImage.setImageResource(R.drawable.ic_like)
        }
        if (post.isComment) {
            commentImage.setImageResource(R.drawable.ic_comment)
        }
        if (post.isShare) {
            shareImage.setImageResource(R.drawable.ic_share)
        }
    }

    fun init(post: Post) {

        autorText.text = post.autor
        postText.text = post.postText
        if (post.like > 0) {
            likeText.text = post.like.toString()
        }
        if (post.comments > 0) {
            commentText.text = post.comments.toString()
        }
        if (post.share > 0) {
            shareText.text = post.share.toString()
        }

        datePost.text = date(post)
        istruth(post)
    }

    fun date(post: Post): String {
        val publishedAgo = (System.currentTimeMillis() - post.data) / 1000
        val toMin = if (publishedAgo > 3599) {
            publishedAgo / 3600
        } else {
            publishedAgo / 60
        }
        val result = when (publishedAgo) {
            in 0..59 -> "менее минуты назад"
            in 60..179 -> "минуту назад"
            in 180..299 -> "$toMin минуты назад"
            in 300..3599 -> "$toMin минут назад"
            in 3600..17999 -> "$toMin часа назад"
            else -> "$toMin часов назад "
        }
        return result


    }


}




