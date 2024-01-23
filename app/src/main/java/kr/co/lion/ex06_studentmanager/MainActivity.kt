package kr.co.lion.ex06_studentmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.lion.ex06_studentmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        setEvent()
    }

    // 이벤트 설정 메서드
    fun setEvent(){

        activityMainBinding.apply{
            endBtn.setOnClickListener {
                val name = nameET.text.toString()
                val age = ageET.text.toString()
                val kor = korET.text.toString().toInt()
                val math = mathET.text.toString().toInt()
                val score = kor + math
                val avg = score / 2

                resultTV.text = "이름: $name\n나이: $age\n국어: $kor\n수학: $math\n총점: $score\n평균: $avg"
            }
        }
    }
}