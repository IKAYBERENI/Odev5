package com.example.odev5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.odev5.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btn0.appendClick("0")
            btn1.appendClick("1")
            btn2.appendClick("2")
            btn3.appendClick("3")
            btn4.appendClick("4")
            btn5.appendClick("5")
            btn6.appendClick("6")
            btn7.appendClick("7")
            btn8.appendClick("8")
            btn9.appendClick("9")
            btn0.appendClick("0")
            btnTopla.appendClick("+")
            btnSil.setOnClickListener{
                binding.islemEkran.text = null
                binding.sonucEkran.text = ""
            }
            btnEsittir.setOnClickListener {
                try {
                    val expression = ExpressionBuilder(binding.islemEkran.text.toString()).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()

                    if (result == longResult.toDouble()) {
                        binding.sonucEkran.text = longResult.toString()
                    } else {
                        binding.sonucEkran.text = result.toString()
                    }
                }catch (e:Exception){
                    Log.e("Exception", "Message: ${e.message}")
                }
            }

        }
    }
    private fun View.appendClick(string: String) {
        setOnClickListener {
            binding.islemEkran.append(string)
        }
    }
}