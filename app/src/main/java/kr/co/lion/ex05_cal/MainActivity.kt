package kr.co.lion.ex05_cal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import kr.co.lion.ex05_cal.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var text1 = 0
        var text2 = 0
        var result = 0

        binding.apply{

            /*editTextText.setOnEditorActionListener { view, i, keyEvent ->
                text1 = view.text.toString().toInt()
                false
            }

            editTextText2.setOnEditorActionListener { view, i, keyEvent ->
                text2 = view.text.toString().toInt()
                false
            }*/

            editTextText.addTextChangedListener {
                text1 = it.toString().toInt()
            }

            editTextText2.addTextChangedListener {
                text2 = it.toString().toInt()
            }

            button.setOnClickListener {
                result = text1 + text2
                button5.text = result.toString()
            }

            button2.setOnClickListener {
                result = text1 - text2
                button5.text = result.toString()
            }

            button3.setOnClickListener {
                result = text1 * text2
                button5.text = result.toString()
            }

            button4.setOnClickListener {
                result = text1 / text2
                button5.text = result.toString()
            }

        }
    }
}