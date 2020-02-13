package com.waribay.award

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {

    private val arrEmail : Array<String> = arrayOf("waribagus@gmail.com", "admin@test.com")
    private lateinit var editEmail : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        editEmail = findViewById(R.id.edit_email);
    }

    fun signingProcess (view: View){

        val emailAddress : String = editEmail.text.toString()

//        if ( arrEmail.contains(emailAddress) ){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("email", emailAddress)
            startActivity(intent)
            finish()
//        } else {
//            Toast.makeText(this.applicationContext, emailAddress.plus(" is not exists"), Toast.LENGTH_SHORT).show();
//        }

    }
}
