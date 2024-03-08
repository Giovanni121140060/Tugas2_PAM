package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.incrementButton.setOnClickListener {
            incrementCounter().toString().also { binding.counterTv.text = it }
        }

        binding.decrementButton.setOnClickListener {
            decreaseCounter().toString().also { binding.counterTv.text = it }
        }
    }

    private fun incrementCounter(): Int {
        return ++counter
    }

    private fun decreaseCounter(): Int {
        if (counter > 0) {
            counter--
        } else {
            Toast.makeText(this, "Invalid number", Toast.LENGTH_LONG).show()
        }
        return counter
    }
}
