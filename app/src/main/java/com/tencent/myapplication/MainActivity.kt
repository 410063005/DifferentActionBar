package com.tencent.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.tencent.myapplication.toolbar1.Host
import com.tencent.myapplication.toolbar2.Host2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar) as Toolbar?)

        btn_demo1.setOnClickListener({
            Host.start(this)
        })
        btn_demo2.setOnClickListener({
            Host2.start(this)
        })
    }
}
