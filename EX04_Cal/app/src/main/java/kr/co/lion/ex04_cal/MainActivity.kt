package kr.co.lion.ex04_cal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kr.co.lion.ex04_cal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.apply {

            resultBtn.setOnClickListener {
                // resultTV.text = ""

                toggleGroup.checkedButtonIds.forEach {
                    when(it){
                        R.id.plusBtn -> {
                            val result = number1ET.text.toString().toInt() + number2ET.text.toString().toInt()
                            resultTV.visibility = View.VISIBLE
                            resultTV.text = "결과는 $result 입니다."
                            }
                        R.id.minusBtn -> {
                            val result = number1ET.text.toString().toInt() - number2ET.text.toString().toInt()
                            resultTV.visibility = View.VISIBLE
                            resultTV.text = "결과는 $result 입니다."
                            }
                        R.id.timesBtn -> {
                            val result = (number1ET.text.toString().toInt()) * (number2ET.text.toString().toInt())
                            resultTV.visibility = View.VISIBLE
                            resultTV.text = "결과는 $result 입니다."
                            }
                        R.id.divBtn ->{
                            val result = number1ET.text.toString().toInt() / number2ET.text.toString().toInt()
                            resultTV.visibility = View.VISIBLE
                            resultTV.text = "결과는 $result 입니다."
                            }
                    }
                }
            }
        }
    }
}