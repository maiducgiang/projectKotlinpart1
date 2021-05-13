package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cost : EditText = findViewById(R.id.cost_of_service)
        val continueButton : Button = findViewById(R.id.Continue)
        val orView : TextView = findViewById(R.id.or)
        continueButton.isClickable = false
        continueButton.setBackgroundColor(resources.getColor(R.color.Gray))
        cost.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                //sau khi văn bản thay đổi

                val email: String = cost.text.toString()
                if(email.isBlank()){
                    continueButton.isClickable = false
                    continueButton.setBackgroundColor(resources.getColor(R.color.Gray))
                }
                else{
                    continueButton.isClickable = true
                    continueButton.setBackgroundColor(resources.getColor(R.color.Red))
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
                //trước khi văn bản thay đổi
                continueButton.isClickable = true
                continueButton.setBackgroundColor(resources.getColor(R.color.Red))
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                //trên văn bản thay đổi
                continueButton.isClickable = true
                continueButton.setBackgroundColor(resources.getColor(R.color.Red))
            }
        })
    }
}
