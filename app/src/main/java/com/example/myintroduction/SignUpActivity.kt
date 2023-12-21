package com.example.myintroduction

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val et_name = findViewById<EditText>(R.id.et_name)
        val et_id = findViewById<EditText>(R.id.et_id)
        val et_password = findViewById<EditText>(R.id.et_password)

        val btn_sign_up = findViewById<Button>(R.id.btn_sign_up)
        btn_sign_up.setOnClickListener{

            val dt_name = et_name.text.toString()
            val dt_id = et_id.text.toString()
            val dt_Password = et_password.text.toString()

            if (dt_id.trim().isEmpty() || dt_Password.trim().isEmpty() || dt_name.trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.signUpActivity_Toast_fail), Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, getString(R.string.signUpActivity_Toast_succes), Toast.LENGTH_SHORT).show()

                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("dataId", dt_id)
                intent.putExtra("dataPassword", dt_Password)

                setResult(RESULT_OK, intent)

                finish()
            }

        }

    }
}