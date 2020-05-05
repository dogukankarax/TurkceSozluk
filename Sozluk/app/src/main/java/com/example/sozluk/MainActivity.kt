package com.example.sozluk

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<ImageButton>(R.id.button)
        var actv = findViewById<AutoCompleteTextView>(R.id.actv)
        var tv = findViewById<TextView>(R.id.tv)
        var tv2 = findViewById<TextView>(R.id.tv2)

        var kelime = resources.getStringArray(R.array.kelime)
        var aciklama = resources.getStringArray(R.array.aciklama)

        var adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, kelime)
        actv.setAdapter(adapter)
        actv.threshold = 1


        button.setOnClickListener {
            var input = actv.text.toString()
            var bos2 = ""
            if (input == bos2) {
                tv.text = "Kelime giriniz"
                tv2.text =""
            }
            for ((index) in kelime.withIndex()) {
                if (input == kelime[index]) {
                    tv.text = aciklama[index]
                    tv2.text = kelime[index]
                }
            }
            hideKeyboard()
        }
    }
    //Klavyeyi kapatmak için gerekli olan fonksiyon
    fun AppCompatActivity.hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}









