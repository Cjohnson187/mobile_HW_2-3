package com.example.assignment_two

import android.graphics.Color.rgb
import android.graphics.ColorFilter
import android.os.Bundle
import android.provider.CalendarContract
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.content_main.*


//*****************************************************************
// Main class

class MainActivity : AppCompatActivity() {
    var save1 = intArrayOf(0, 0, 0)
    var save2 = intArrayOf(0, 0, 0)
    var save3 = intArrayOf(0, 0, 0)


    var value1 = 0
    var value2 = 0
    var value3 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        //setHasOptionsMenu(true)

        val text1 = this.findViewById<TextView>(R.id.textB1)
        val text2 = this.findViewById<TextView>(R.id.textB2)
        val text3 = this.findViewById<TextView>(R.id.textB3)

        val seekBar1 = this.findViewById<SeekBar>(R.id.seekBar1)
        val seekBar2 = this.findViewById<SeekBar>(R.id.seekBar2)
        val seekBar3 = this.findViewById<SeekBar>(R.id.seekBar3)

        //val menu1 = this.onMenuItemClickListener

        val but = findViewById<Button>(R.id.button)
        but.setOnClickListener {
            Toast.makeText(this, save2[1].toString(), LENGTH_SHORT).show()

        }

        seekBar1.progress = value1 // set variable to seek bar value
        seekBar2.progress = value2 // set variable to seek bar value
        seekBar3.progress = value3 // set variable to seek bar value

        text1.text = value1.toString()
        text2.text = value2.toString()
        text3.text = value3.toString()

        val surface = this.surfaceView

        //***************************************************************************
        // Seek bar 1 controls
        seekBar1.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, b: Boolean) {
                value1 = i
                text1.text = "$value1"
                text1.setTextColor(rgb(value1, 0, 0))
                surface.setBackgroundColor(rgb(value1, value2, value3))
            }
        })
        //****************************************************************************
        // Seek bar 2 controls

        seekBar2.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, b: Boolean) {
                value2 = i
                text2.text = "$value2"
                text2.setTextColor(rgb(0, value2, 0))
                surface.setBackgroundColor(rgb(value1, value2, value3))
            }
        })
        //***************************************************************************
        // Seek bar 3 controls
        seekBar3.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(seekBar: SeekBar?) {} // unused
            override fun onStartTrackingTouch(seekBar: SeekBar?) {} // unused
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, b: Boolean) {
                value3 = i
                text3.text = "$value3"
                text3.setTextColor(rgb(0, 0, value3))
                surface.setBackgroundColor(rgb(value1, value2, value3))
            }
        })
        //***************************************************************************
    } // End of seek bar controls

    //***************************************************************
    // Method to expand menu bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    //***************************************************************
    // Method to make each buttons do something
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        //**********************************************************
        // Save button 1
        R.id.s1 -> {
            save1[0] = value1
            save1[1] = value2
            save1[2] = value3

            true
        }

        //**********************************************************
        // Save button 2
        R.id.s2 -> {
            save2[0] = value1
            save2[1] = value2
            save2[2] = value3

            true
        }
        //**********************************************************
        // Save button 3
        R.id.s3 -> {
            save3[0] = value1
            save3[1] = value2
            save3[2] = value3

            true
        }

        //**********************************************************
        // if action was not recognized, invoke super class

        else -> {
            super.onOptionsItemSelected(item)
        }

        //*****************_End of button commands_*****************
    }

    //**************************************************************


}
