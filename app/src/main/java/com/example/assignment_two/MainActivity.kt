package com.example.assignment_two

import android.graphics.Color.rgb
import android.os.Bundle
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

class MainActivity : AppCompatActivity() {
    var save1 = intArrayOf(0, 0, 0)
    var save2 = intArrayOf(0, 0, 0)
    var save3 = intArrayOf(0, 0, 0)


    var value1 = 0
    var value2 = 0
    var value3 = 0

    //val but = findViewById<Button>(R.id.button)





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
            Toast.makeText(this, save1[0].toString(), LENGTH_SHORT).show()

        }

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
        menuInflater.inflate(R.menu.menu_main, menu)

/*
         override fun onMenuItemClick (item: MenuItem) {
            when (item.itemId) {
                R.id.s1 ->  {

                    save1[0] = value1
                    save1[1] = value2
                    save1[2] = value3

                   // Toast.makeText(this, value1, LENGTH_SHORT)
                }

            }

        }*/

        return true
    }

    /*fun onMenuItemClickListener (item: MenuItem) {
        when (item.itemId) {
            R.id.s1 ->  {

                save1[0] = value1
                save1[1] = value2
                save1[2] = value3

            }

        }

    }*/

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.s1 -> {
            save1[0] = value1
            save1[1] = value2
            save1[2] = value3

            // User chose the "Settings" item, show the app settings UI...
            true
        }

        R.id.s2 -> {
            // User chose the "Favorite" action, mark the current item
            // as a favorite...
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }



}
