package com.example.assignment_two

import android.graphics.Color.rgb
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    var save1 = intArrayOf(0, 0, 0)
    var save2 = intArrayOf(0, 0, 0)
    var save3 = intArrayOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val text1 = this.findViewById<TextView>(R.id.textB1)
        val text2 = this.findViewById<TextView>(R.id.textB2)
        val text3 = this.findViewById<TextView>(R.id.textB3)

        val seekBar1 = this.findViewById<SeekBar>(R.id.seekBar1)
        val seekBar2 = this.findViewById<SeekBar>(R.id.seekBar2)
        val seekBar3 = this.findViewById<SeekBar>(R.id.seekBar3)

        var value1 = 0
        var value2 = 0
        var value3 = 0


        seekBar1.progress = value1
        seekBar2.progress = value2
        seekBar3.progress = value3

        text1.text = value1.toString()
        text2.text = value2.toString()
        text3.text = value3.toString()

        val surface = this.surfaceView


        seekBar1.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, b: Boolean) {
                value1 = i
                text1.text = "$value1"
                text1.setTextColor(rgb(value1, 0, 0))
                surface.setBackgroundColor(rgb(value1, value2, value3))

            }
        })

        seekBar2.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, b: Boolean) {
                value2 = i
                text2.text = "$value2"
                text2.setTextColor(rgb(0, value2, 0))
                surface.setBackgroundColor(rgb(value1, value2, value3))

            }
        })

        seekBar3.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, b: Boolean) {
                value3 = i
                text3.text = "$value3"
                text3.setTextColor(rgb(0, 0, value3))

                surface.setBackgroundColor(rgb(value1, value2, value3))

            }



        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        //val button1 = this.findViewById<menuItem>()
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    //override fun onMenuItemClick(MenuItem item)

}