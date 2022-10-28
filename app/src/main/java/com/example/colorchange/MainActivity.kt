package com.example.colorchange

import android.graphics.Color
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var Layout: ConstraintLayout
    private lateinit var change: Button
    private lateinit var say: Button
    private lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Layout = findViewById<ConstraintLayout>(R.id.Layout)
        val change = findViewById<Button>(R.id.change)
        val say = findViewById<Button>(R.id.say)
        change.setOnClickListener(View.OnClickListener {
            val random = Random.Default
            val color =
                Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
            Layout.setBackgroundColor(color)
        say.setOnClickListener(View.OnClickListener {
            textToSpeech = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                if(it == TextToSpeech.SUCCESS){
                    textToSpeech.language = Locale.ENGLISH
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak(Layout.background.toString(), TextToSpeech.QUEUE_ADD, null)
                }
            })

        })
        })
    }
}




