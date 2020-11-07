package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var  resultTextView: TextView
    private var secOperand:Double = 0.0
    private var operator = ""
    private var operand:Double = 0.0
    private lateinit var operatorText:TextView
    private lateinit var firstNum:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.result)
        operatorText = findViewById(R.id.operator)
        firstNum = findViewById(R.id.firstnum)
        findViewById<TextView>(R.id.clear).setOnClickListener(){
            operand = 0.0
            operator = ""
            secOperand = 0.0
            resultTextView.text = ""
            operatorText.text = ""
            firstNum.text = ""
        }
    }

    fun deleteClick(view: View) {
        if (view is TextView) {

            var deleting = resultTextView.text.toString().toDouble()
            if (deleting % 1 != 0.0) {
                resultTextView.text = ""
            } else {
                var deleting1 = deleting.toLong()

                deleting1 /= 10
                resultTextView.text = deleting1.toString()
            }


        }
    }

    fun numberClick(view: View){

        if(view is TextView){
            val number = view.text.toString()
            var result = resultTextView.text.toString()
            if(result == "0"){
                result = ""
            }
            resultTextView.text = result+number

        }

    }


    fun operantClick(view: View){

        if(view is TextView){

            if(!TextUtils.isEmpty(resultTextView.text)){
                operand = resultTextView.text.toString().toDouble()
            }



            operator = view.text.toString()
            operatorText.text = operator
            firstNum.text = resultTextView.text.toString()
            resultTextView.text = ""


        }

    }

    fun equalsClick(view: View){

        val secOperandText:String = resultTextView.text.toString()

        if (view is TextView){
            if(!TextUtils.isEmpty(secOperandText)){

                secOperand = secOperandText.toDouble()


            }

            when(operator){


                "+" -> {
                    resultTextView.text = (operand + secOperand).toString()
                    operatorText.text= ""
                    firstNum.text = ""
                }
                "*" ->{
                    resultTextView.text = (operand * secOperand).toString()
                    operatorText.text= ""
                    firstNum.text = ""
                }
                "-" -> {
                    operatorText.text= ""
                    firstNum.text = ""
                    resultTextView.text = (operand - secOperand).toString()
                }
                "/" -> {
                    operatorText.text= ""
                    firstNum.text = ""
                    resultTextView.text = (operand / secOperand).toString()
                }
                "X^Y" -> {
                    operatorText.text= ""
                    firstNum.text = ""
                    var times:Long=secOperand.toLong()
                    var operand1 = operand
                   for (i in 1 until times) operand1*= operand
                    resultTextView.text = operand1.toString()
                }


            }
            var result = resultTextView.text.toString().toDouble()

            if(result % 1 == 0.0){
                var result1 = result.toDouble().toLong()
                resultTextView.text = result1.toString()
            }
        }


    }


}