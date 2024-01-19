package kr.co.lion.android10_logcat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 총 6가지 있다.
        // 어떤 걸 쓰더라도 주어진 메세지를 출력하는 것은 동일하다.
        // 메서드에 따라서 출력 되는 색상이 달라 진다.
        // 용도에 맞게 사용 하는 것을 권장 한다.

        // 첫 번째 매개 변수 : 필터 문자열
        // 두 번째 매개 변수 : 출력 하고 싶은 문자열

        // d : debug, 주로 개발자가 출력하고 싶은 메시지를 출력하는데 사용한다.
        // 다른 메서드에 해당하지 않는 것들을 출력할 때 사용한다.
        Log.d("test1234", "debug")

        // e : error, 오류에 관련된 메시지를 출력하는데 사용한다.
        // 애플리케이션에서 오류가 발생하면 오류 메시지는 그냥 출력된다.
        Log.e("test1234", "error")

        // i : information, 정보성 메시지를 출력하는데 사용한다.
        Log.i("test1234", "information")

        // v : verbose, 상세한 설명 메시지를 출력하는데 사용한다.
        Log.v("test1234", "verbose")

        // w : warning, 경고성 메시지를 출력하는데 사용한다.
        Log.w("test1234", "warning")

        // wtf : What a Terrible Failure(What the Fxxk),
        // 절대로 일어나서는 안되는 일이 벌어졌을때의 메시지를
        // 출력하는데 사용한다.
        Log.wtf("test1234", "What the Fxxk")

    }
}