package com.example.assignment_two

import android.graphics.Color.rgb
import android.graphics.ColorFilter
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.SurfaceView
import android.widget.*
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.content_main.*


//*****************************************************************
// Main class
class MainActivity : AppCompatActivity() {



    // global variables
    var save1 = intArrayOf(0, 0, 0) // array variable for save button vvalues
    var save2 = intArrayOf(0, 0, 0) // array variable for save button vvalues
    var save3 = intArrayOf(0, 0, 0) // array variable for save button vvalues

    var value1 = 0 // variable to set sugit rface view color  ( Red )
    var value2 = 0 // variable to set surface view color  ( Green )
    var value3 = 0 // variable to set surface view color  ( Bl:ue )

    //val surface1:SurfaceView? = null

    //var message: String = "new"

   // var surface1: SurfaceView = findViewById(R.id.surfaceView)

   // var spinner1 = this.findViewById<Spinner>(R.id.spinner)


    // initialize app
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)  // Menu item support

        val text1 = this.findViewById<TextView>(R.id.textB1) // text field to show seek values
        val text2 = this.findViewById<TextView>(R.id.textB2) // text field to show seek values
        val text3 = this.findViewById<TextView>(R.id.textB3) // text field to show seek values

        val seekBar1 = this.findViewById<SeekBar>(R.id.seekBar1) // seek bar var
        val seekBar2 = this.findViewById<SeekBar>(R.id.seekBar2) // seek bar var
        val seekBar3 = this.findViewById<SeekBar>(R.id.seekBar3) // seek bar var

        // ***********************************************************************
        // button to test loading before making load buttons
        //val but = findViewById<Button>(R.id.button)
        //but.setOnClickListener {
          //  Toast.makeText(this, save2[1].toString(), LENGTH_SHORT).show()
        //}
        // ***********************************************************************

        seekBar1.progress = value1 // set variable to seek bar value
        seekBar2.progress = value2 // set variable to seek bar value
        seekBar3.progress = value3 // set variable to seek bar value

        text1.text = value1.toString() // convert to string just in case
        text2.text = value2.toString() // convert to string just in case
        text3.text = value3.toString() // convert to string just in case

        val surface1 = this.surfaceView // create surface variable



        //***************************************************************************
        // Seek bar 1 controls
        seekBar1.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, b: Boolean) {
                value1 = i
                text1.text = "$value1"
                text1.setTextColor(rgb(value1, 0, 0))
                surface1.setBackgroundColor(rgb(value1, value2, value3))
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
                //surface1.setBackgroundColor()
                surface1.setBackgroundColor(rgb(value1, value2, value3))
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
                surface1.setBackgroundColor(rgb(value1, value2, value3))
            }
        })
        //***************************************************************************

    } // End of on_Create

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
        // Save button
        R.id.save -> {

            // save each value to array slot for rgb format
           // val

            save1[0] = value1
            save1[1] = value2
            save1[2] = value3


            //val spin : Spinner =findViewById(R.id.spinner)
            val write = Toast.makeText(applicationContext, "$value1[0]", Toast.LENGTH_LONG)
            write.show()

            //print("Type a name for the color")
            //var m = readLine()
            //print("you picked $m")
            //message = m

            true
        }

        //**********************************************************
        // load button
        R.id.load -> {
            // save each value to array slot for rgb format
            save2[0] = value1
            save2[1] = value2
            save2[2] = value3

            true
        }

        //**********************************************************



        //**********************************************************
        // if action was not recognized, invoke super class

        else -> {
            super.onOptionsItemSelected(item)
        }


        //*****************_End of button commands_*****************


    } // end on_Option_Item_Selected

    //**************************************************************

}// end of main class
