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

    val saveM = this.menuI

    var colorName = ""


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

            var textField = input.text
            var saveC = this.findViewById<Button>(R.id.confirm)

            input.visibility = View.VISIBLE
            saveC.visibility = View.VISIBLE

            //colorName = readLine()!!
            //println("you entered $colorName")
            //input.read
            saveC.setOnClickListener {

                colorName = textField.toString()
                val saveS = Toast.makeText(applicationContext, "$colorName" + " saved", Toast.LENGTH_LONG)
                saveS.show()

                // save each value to array slot for rgb format
                save1[0] = colorName
                save1[1] = value1.toString()
                save1[2] = value2.toString()
                save1[3] = value3.toString()

                input.visibility = View.INVISIBLE
                saveC.visibility = View.INVISIBLE


                //save.getElementById(save).innerHTML = colorName


            }



            //var textField = editText.text
            //input.


            //var textField = input.text

/*
            colorName = textField.toString()

            val saveS = Toast.makeText(applicationContext, "$colorName", Toast.LENGTH_LONG)
            saveS.show()

            // save each value to array slot for rgb format
            save1[0] = colorName
            save1[1] = value1.toString()
            save1[2] = value2.toString()
            save1[3] = value3.toString()

            input.visibility = View.INVISIBLE
            */

            true
        }

        //**********************************************************
        // load button
        R.id.l1 -> {

            //val spin : Spinner =findViewById(R.id.spinner)
            val surface1 = this.surfaceView // create surface variable

            val text1 = this.findViewById<TextView>(R.id.textB1) // text field to show seek values
            val text2 = this.findViewById<TextView>(R.id.textB2) // text field to show seek values
            val text3 = this.findViewById<TextView>(R.id.textB3) // text field to show seek values

            value1 = save1[1].toInt()
            value2 = save1[2].toInt()
            value3 = save1[3].toInt()

            seekBar1.progress = value1 // set variable to seek bar value
            seekBar2.progress = value2 // set variable to seek bar value
            seekBar3.progress = value3 // set variable to seek bar value

            text1.text = "$value1"
            text2.text = "$value2"
            text3.text = "$value3"

            text1.setTextColor(rgb(value1, 0, 0))
            text2.setTextColor(rgb(0, value2, 0))
            text3.setTextColor(rgb(0, 0, value3))

            surface1.setBackgroundColor(rgb(save1[1].toInt(),save1[2].toInt(),save1[3].toInt()))

            true
        }

        //**********************************************************
        R.id.l2 -> {

            //val spin : Spinner =findViewById(R.id.spinner)

            val surface1 = this.surfaceView // create surface variable

            val text1 = this.findViewById<TextView>(R.id.textB1) // text field to show seek values
            val text2 = this.findViewById<TextView>(R.id.textB2) // text field to show seek values
            val text3 = this.findViewById<TextView>(R.id.textB3) // text field to show seek values

            value1 = save1[1].toInt()
            value2 = save1[2].toInt()
            value3 = save1[3].toInt()

            seekBar1.progress = value1 // set variable to seek bar value
            seekBar2.progress = value2 // set variable to seek bar value
            seekBar3.progress = value3 // set variable to seek bar value

            text1.text = "$value1"
            text2.text = "$value2"
            text3.text = "$value3"

            text1.setTextColor(rgb(value1, 0, 0))
            text2.setTextColor(rgb(0, value2, 0))
            text3.setTextColor(rgb(0, 0, value3))

            surface1.setBackgroundColor(rgb(save1[1].toInt(),save1[2].toInt(),save1[3].toInt()))


            true
        }

        //**********************************************************
        R.id.l3 -> {

            //val spin : Spinner =findViewById(R.id.spinner)




            val surface1 = this.surfaceView // create surface variable

            val text1 = this.findViewById<TextView>(R.id.textB1) // text field to show seek values
            val text2 = this.findViewById<TextView>(R.id.textB2) // text field to show seek values
            val text3 = this.findViewById<TextView>(R.id.textB3) // text field to show seek values



            value1 = save1[1].toInt()
            value2 = save1[2].toInt()
            value3 = save1[3].toInt()

            seekBar1.progress = value1 // set variable to seek bar value
            seekBar2.progress = value2 // set variable to seek bar value
            seekBar3.progress = value3 // set variable to seek bar value

            text1.text = "$value1"
            text2.text = "$value2"
            text3.text = "$value3"



            text1.setTextColor(rgb(value1, 0, 0))
            text2.setTextColor(rgb(0, value2, 0))
            text3.setTextColor(rgb(0, 0, value3))





            surface1.setBackgroundColor(rgb(save1[1].toInt(),save1[2].toInt(),save1[3].toInt()))


            true
        }
        //**********************************************************
        R.id.d1 -> {

            save1[0] = "new"
            save1[1] = "0"
            save1[2] = "0"
            save1[3] = "0"



            true
        }

        //**********************************************************
        R.id.d2 -> {

            save2[0] = "new"
            save2[1] = "0"
            save2[2] = "0"
            save2[3] = "0"



            true
        }

        //**********************************************************
        R.id.d3 -> {

            save3[0] = "new"
            save3[1] = "0"
            save3[2] = "0"
            save3[3] = "0"



            true
        }

        //**********************************************************
        // if action was not recognized, invoke super class

        else -> {
            super.onOptionsItemSelected(item)
        }

        //*****************_End of button commands_*****************

    } // end on_Option_Item_Selected


    //**************************************************************

}// end of main class
