package com.example.practica2

import android.content.Context
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.practica2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var doneBtn : Button
    lateinit var editText : EditText
    lateinit var nicknameTextView : TextView
    lateinit var binding : ActivityMainBinding
    private var myName2: MyName = MyName(name = "BAIT")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName1 = myName2
//        setContentView(R.layout.activity_main)
//        doneBtn = findViewById<Button>(R.id.done_button)
//        editText = findViewById<EditText>(R.id.nickname_edit)
//        nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickname(view : View){
//        binding.nicknameText.text = binding.nicknameEdit.text.toString()
//        binding.nicknameEdit.visibility = View.GONE
//        binding.doneButton.visibility = View.GONE
//        binding.nicknameText.visibility = View.VISIBLE

        binding.apply{
            myName1?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

//        nicknameTextView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view : View){
        binding.apply{
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE
        }

//        editText.visibility = View.VISIBLE
//        doneBtn.visibility = View.VISIBLE
//        view.visibility = View.GONE
    }
}