package com.example.lesson5_1.View

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lesson5_1.R
import com.example.lesson5_1.databinding.ActivityMainBinding
import com.example.lesson5_1.presenter.Presenter


class MainActivity : AppCompatActivity(),CounterView {
    var presenter  = Presenter()
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClicker()
    }
    private fun initClicker(){
        with(binding){
            btnPlus.setOnClickListener {
                presenter.increment()
            }
        }
    }
    override fun showToast() {
        Toast.makeText(this, "Поздравляю!!!", Toast.LENGTH_SHORT).show()
    }
    override fun setColor() {
        binding.tvResult.setBackgroundColor(Color.GREEN)
    }
    override fun updateCounter(count: Int) {
        binding.tvResult.text = count.toString()
    }
}