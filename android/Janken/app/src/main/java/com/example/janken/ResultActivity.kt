package com.example.janken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    val gu = 0
    val choki = 1
    val pa = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val id = intent.getIntExtra("MY_HAND", 0)

        // タップされた画像表示
        when(id) {
            R.id.gu -> myHandImage.setImageResource(R.drawable.ic_launcher_foreground)
            R.id.pa -> myHandImage.setImageResource(R.drawable.pa)
            R.id.choki -> myHandImage.setImageResource(R.drawable.ic_launcher_foreground)
        }


        val myHand: Int
        myHand = when(id) {
            R.id.gu -> {
                myHandImage.setImageResource(R.drawable.ic_launcher_foreground)
                gu
            }
            R.id.choki -> {
                myHandImage.setImageResource(R.drawable.ic_launcher_foreground)
                choki
            }
            R.id.pa -> {
                myHandImage.setImageResource(R.drawable.pa)
                pa
            }
            else -> gu
        }

        // コンピュータの手を決める
        val comHand = (Math.random() * 3).toInt()
        when(comHand) {
            gu -> comHandImage.setImageResource(R.drawable.ic_launcher_foreground)
            choki -> comHandImage.setImageResource(R.drawable.ic_launcher_foreground)
            pa -> comHandImage.setImageResource(R.drawable.pa)
        }

        // 勝敗を判定する
        val gameResult = (comHand - myHand + 3) % 3

        when(gameResult) {
            0 -> resultLabel.setText(R.string.result_draw)
            1 -> resultLabel.setText(R.string.result_win)
            2 -> resultLabel.setText(R.string.result_lose)
        }

        backButton.setOnClickListener { finish() }

    }
}
