package com.udacity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.udacity.MainActivity.Companion.INTENT_FILENAME
import com.udacity.MainActivity.Companion.INTENT_STATUS
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        val fileName = intent.getStringExtra(INTENT_FILENAME)
        val status = intent.getStringExtra(INTENT_STATUS)
        Log.d("detailactivity", "this is a message $status    $fileName")


        tv_file.text = fileName.toString()
        tv_status.text = status.toString()
        if (status == getString(R.string.status_success)) {
            tv_status.setTextColor(this.getColor(R.color.green))
        } else {
            tv_status.setTextColor(this.getColor(R.color.red))

        }

        btn_ok.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


    }

}
