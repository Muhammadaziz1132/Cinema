package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cinema.Models.Cinema
import com.example.cinema.kesh.MySharedPrefarance
import kotlinx.android.synthetic.main.activity_add_movie.*

class AddMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)
        MySharedPrefarance.init(this)

        btn_save.setOnClickListener {
            val arrayCinema = MySharedPrefarance.obektString

            val name = edt_movies_name.text.toString().trim()
            val authors = edt_aithors_movie.text.toString().trim()
            val about = edt_about_movies.text.toString().trim()
            val date = edt_movie_date.text.toString().trim()

            if (name!=""&&authors!="" && date!="" && about!="") {
                arrayCinema.add(Cinema(name, authors, about, date))
                println(arrayCinema)

                MySharedPrefarance.obektString = arrayCinema
                finish()
            }else{
                Toast.makeText(this, "EditText is empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

}