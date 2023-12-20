package com.example.myintroduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val str_data = intent.getStringExtra("dataId")
        val tv_user_id = findViewById<TextView>(R.id.tv_user_id)
        tv_user_id.setText(str_data)


        val iv_home = findViewById<ImageView>(R.id.iv_home)
        val img_list = listOf( R.drawable.profile1, R.drawable.profile2, R.drawable.profile3, R.drawable.profile4, R.drawable.profile5)
        val randomNum = (0..4).random()
        iv_home.setImageResource(img_list[randomNum])

        val btn_close = findViewById<Button>(R.id.btn_close)
        btn_close.setOnClickListener{
            finish()
        }
    }
}