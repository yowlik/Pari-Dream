package com.naturalmotion.csrracin.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naturalmotion.csrracin.R
import com.naturalmotion.csrracin.databinding.ActivityResBinding

class Res : AppCompatActivity() {
    lateinit var binding:ActivityResBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityResBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.scoret.text=getIntent().getStringExtra("key")
        binding.start.setOnClickListener {
            val intent1= Intent(this@Res,Game::class.java)
            startActivity(intent1)
        }
    }
}