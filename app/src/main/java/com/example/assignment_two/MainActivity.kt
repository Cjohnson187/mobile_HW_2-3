package com.example.assignment_two

import android.graphics.Color.RGBToHSV
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
import android.view.View
import android.widget.*
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.content_main.*


//*****************************************************************
// Main class
class MainActivity : AppCompatActivity() {
    //lateinit var editText : EditText

    var value1 = 0 // variable to set surface view color  ( Red )
    var value2 = 0 // variable to set surface view color  ( Green )
    var value3 = 0 // variable to set surface view color  ( Bl:ue )

    var save1 = arrayOf("new", "0", "0", "0") // array variable for save button values
    var save2 = arrayOf("new", "0", "0", "0") // array variable for save button values
    var save3 = arrayOf("new", "0", "0", "0") // array variable for save button values

    var colorName = ("none")


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

            input.visibility = View.VISIBLE
            //input.read



            //var textField = editText.text
            //input.


            var textField = input.text


            colorName = textField.toString()

            val saveS = Toast.makeText(applicationContext, "$colorName", Toast.LENGTH_LONG)
            saveS.show()

            // save each value to array slot for rgb format
            save1[0] = colorName
            save1[1] = value1.toString()
            save1[2] = value2.toString()
            save1[3] = value3.toString()

            input.visibility = View.INVISIBLE



            true
        }

       /* R.id.save -> {

            //var textField = this.input

            //var colorName = textField.text.toString()

            input.visibility = View.INVISIBLE


            val saveS = Toast.makeText(applicationContext, "$colorName", Toast.LENGTH_LONG)
            saveS.show()

            // save each value to array slot for rgb format
            save1[0] = colorName
            save1[1] = value1.toString()
            save1[2] = value2.toString()
            save1[3] = value3.toString()


            true
        }*/

        //**********************************************************
        // load button
        R.id.load -> {

            val spin : Spinner =findViewById(R.id.spinner)




            val surface1 = this.surfaceView // create surface variable


            surface1.setBackgroundColor(rgb(save1[1].toInt(),save1[2].toInt(),save1[3].toInt()))


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
