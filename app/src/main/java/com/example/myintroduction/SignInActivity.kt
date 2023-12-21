package com.example.myintroduction

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        val et_id = findViewById<EditText>(R.id.et_id)
        val et_password = findViewById<EditText>(R.id.et_password)

        resultLauncher= registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val id = result.data?.getStringExtra("dataId")
                val password = result.data?.getStringExtra("dataPassword")

                et_id.setText(id)
                et_password.setText(password)
            }
        }


        val btn_login = findViewById<Button>(R.id.btn_login)
        btn_login.setOnClickListener {

            val dt_id = et_id.text.toString()
            val dt_Password = et_password.text.toString()

            if (dt_id.trim().isEmpty() || dt_Password.trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.signInActivity_Toast_fail), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, getString(R.string.signInActivity_Toast_succes), Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("dataId", dt_id)
                startActivity(intent)
            }

        }

        val btn_sign_up = findViewById<Button>(R.id.btn_sign_up)
        btn_sign_up.setOnClickListener{
            val intent = Intent(this,SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }

    }
}