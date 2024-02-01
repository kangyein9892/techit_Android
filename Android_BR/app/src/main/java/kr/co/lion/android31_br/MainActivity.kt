package kr.co.lion.android31_br

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val permissionList = arrayOf(
        android.Manifest.permission.RECEIVE_SMS,
        android.Manifest.permission.RECEIVE_BOOT_COMPLETED,
        android.Manifest.permission.READ_PHONE_STATE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermissions(permissionList, 0)
    }
}