package com.example.lesson5_1.presenter

import com.example.lesson5_1.View.CounterView
import com.example.lesson5_1.model.CounterModel


class Presenter {
    private val model = CounterModel()
    lateinit var view: CounterView
    fun increment() {
        model.increment()
        view.updateCounter(model.count)
        if (model.getCount() == 10){
            view.showToast()
        }else if (model.getCount() == 15){
            view.setColor()

        }}


    fun attachView(view: CounterView) {
        this.view = view
    }}