package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView:TextView
    private var firstOper = 0.0
    private var operation = ""
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = this.findViewById(R.id.textView)
    }

    fun numClick(clickView: View){
        if(clickView is Button){
            var result = resultTextView.text.toString()
            var buttonNumber = clickView.text.toString()

            if(result == "0"){
                result = ""
            }
            var res = result +buttonNumber
            resultTextView.text = res
        }
    }

    fun onOperator(clickView: View){
        if(clickView is Button){
            var firstNum = resultTextView.text.toString()
            if(firstNum.isNotEmpty()){
                firstOper = firstNum.toDouble()
            }
            this.operation = clickView.text.toString()
            resultTextView.text = ""

            when (operation) {
                "+/-" -> resultTextView.text = (firstOper * -1).toString()
                "√" -> resultTextView.text = sqrt(firstOper).toString()
            }
        }
    }

    fun equalClick(clickView: View){
        var secNum = resultTextView.text.toString()
        var sn = 0.0
        if(secNum.isNotEmpty()){
            sn = secNum.toDouble()
        }
        when(operation){
            "+" -> resultTextView.text = (firstOper + sn).toString()
            "-" -> resultTextView.text = (firstOper - sn).toString()
            "*" -> resultTextView.text = (firstOper * sn).toString()
            "/" -> resultTextView.text = (firstOper / sn).toString()
        }
    }

    fun onClear(clickView: View){
        resultTextView.text = "0"
        firstOper = 0.0
        operation = ""
    }
}