package com.developer.kotlinsharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }




    fun veriekle(view: View)
    {
        val sharedPreferences = this.getSharedPreferences(packageName,android.content.Context.MODE_PRIVATE)

        val adsoyad = editText.text.toString()
        val sifre  = editText2.text.toString()

        sharedPreferences.edit().putString("adsoyad", adsoyad).apply()
        sharedPreferences.edit().putString("sifre",sifre).apply()

        editText.setText("")
        editText2.setText("")

    }


    fun veriGoster(view: View)
    {
        val sharedPreferences = this.getSharedPreferences(packageName,android.content.Context.MODE_PRIVATE)
        val isimGoster = sharedPreferences.getString("adsoyad","isimsiz")
        val sifreGoster = sharedPreferences.getString("sifre","şifre yok")
        Toast.makeText(applicationContext,"İsim : $isimGoster - Şifre : $sifreGoster",Toast.LENGTH_LONG).show()
    }

    fun veriSil(view: View)
    {
        val sharedPreferences = this.getSharedPreferences(packageName,android.content.Context.MODE_PRIVATE)

        sharedPreferences.edit().remove("adsoyad").apply()
        sharedPreferences.edit().remove("sifre").apply()

    }
}
