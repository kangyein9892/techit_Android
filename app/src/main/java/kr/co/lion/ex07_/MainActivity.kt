package kr.co.lion.ex07_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.checkbox.MaterialCheckBox.CheckedState
import kr.co.lion.ex07_.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.apply{

            switchBtn.setOnCheckedChangeListener { buttonView, isChecked ->
                when(isChecked){
                    true-> {
                        soccer.isEnabled = true
                        basketball.isEnabled = true
                        baseball.isEnabled = true
                    }
                    false ->{
                        soccer.isEnabled = false
                        basketball.isEnabled = false
                        baseball.isEnabled = false
                    }
                }
            }


            button.setOnClickListener {
                textView.visibility = View.VISIBLE
                textView.text = "이름: ${nameTextField.text.toString()}\n"
                textView.append("아이디: ${idTextField.text.toString()}\n")
                textView.append("취미: ")

                if((soccer as MaterialCheckBox).checkedState == MaterialCheckBox.STATE_CHECKED){
                    textView.append("축구 ")
                }
                if((basketball as MaterialCheckBox).checkedState == MaterialCheckBox.STATE_CHECKED){
                    textView.append("농구 ")
                }
                if ((baseball as MaterialCheckBox).checkedState == MaterialCheckBox.STATE_CHECKED){
                    textView.append("야구")
                }
                val hobbyCheck = ((soccer as MaterialCheckBox).checkedState == MaterialCheckBox.STATE_CHECKED) &&
                        ((basketball as MaterialCheckBox).checkedState == MaterialCheckBox.STATE_CHECKED) &&
                        ((baseball as MaterialCheckBox).checkedState == MaterialCheckBox.STATE_CHECKED)
                if(hobbyCheck) {
                    textView.append("없습니다.")
                }
            }
        }
    }
}