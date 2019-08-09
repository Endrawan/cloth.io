package com.example.cloth_io.activities

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.cloth_io.R.layout.activity_trivia
import com.example.cloth_io.models.Trivia
import components.AppCompatActivity
import kotlinx.android.synthetic.main.activity_trivia.*

class TriviaActivity : AppCompatActivity() {

    private lateinit var trivia:Trivia

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_trivia)

        trivia = gson.fromJson(intent.getStringExtra("trivia"), Trivia::class.java)
        Glide.with(this).load(trivia.img).into(image)
        desc.text = trivia.content
        triviaTitle.text = trivia.name
    }
}
