package jp.techacademy.naoya.konita.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        showTimePickerDialog()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener {view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                // 0:00を起点として分単位に変換する
                val input_time = hour * 60 + minute

                if((input_time >= (2*60)) && (input_time < (10*60))) { // 2:00 ~ 9:59
                    textView.text = "おはよう"
                } else if((input_time >= (10*60)) && (input_time < (18*60))) { // 10:00 ~ 17:59
                    textView.text = "こんにちは"
                } else { // 18:00 ~ 1:59
                    textView.text = "こんばんは"
                }
            },
            13,0,true
        )
        timePickerDialog.show()
    }
}