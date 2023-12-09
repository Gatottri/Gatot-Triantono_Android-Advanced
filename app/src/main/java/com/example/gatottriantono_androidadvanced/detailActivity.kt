package com.example.gatottriantono_androidadvanced

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class detailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val getData = intent.getParcelableExtra<DataClass>("android")
        if (getData != null){
            val detailTitle : TextView = findViewById(R.id.detailtitle)
            val detailDesc : TextView= findViewById(R.id.desc)
            val detailImage : ImageView = findViewById(R.id.detailimage)

            detailTitle.text = getData.dataTitle
            detailDesc.text = getData.dataDesc
            detailImage.setImageResource(getData.dataDetailImage)
        }
    }
}