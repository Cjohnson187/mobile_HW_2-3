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
import android.widget.AdapterView.OnItemSelectedListener
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

    var save1 = arrayOf("new1", "0", "0", "0") // array variable for save button values
    //var save2 = arrayOf("new2", "0", "0", "0") // array variable for save button values
    //var save3 = arrayOf("new3", "0", "0", "0") // array variable for save button values
    //val spin = spinner.findViewById<Spinner>(R.id.spinner)
    //var names = arrayOf("new1", "new2", "new3")
    //var saveS = button.findViewById<Button>(R.id.button)

    //var colorName = ""


    // initialize app
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)  // Menu item support

        //*********************************************
        //val spin = spinner.findViewById<Spinner>(R.id.spinner)
        //val adapter = ArrayAdapter (
        //    this, android.R.layout.simple_spinner_item, names
       // )
        //adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        //spin.adapter = adapter

        //************************************************************


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
/*
        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()

                if (selectedItem == save1[0]) {

                    val spin = spinner.findViewById<Spinner>(R.id.spinner)
                    spin.visibility = View.VISIBLE

                    //names[0] = "cool"
                    //val surface1 = this.surfaceView // create surface variable

                    //val text1 = this.findViewById<TextView>(R.id.textB1) // text field to show seek values
                    //val text2 = this.findViewById<TextView>(R.id.textB2) // text field to show seek values
                    //val text3 = this.findViewById<TextView>(R.id.textB3) // text field to show seek values

                    value1 = save1[1].toInt()
                    value2 = save1[2].toInt()
                    value3 = save1[3].toInt()

                    seekBar1.progress = value1 // set variable to seek bar value
                    seekBar2.progress = value2 // set variable to seek bar value
                    seekBar3.progress = value3 // set variable to seek bar value

                    textB1.text = "$value1"
                    textB2.text = "$value2"
                    textB3.text = "$value3"

                    text1.setTextColor(rgb(value1, 0, 0))
                    text2.setTextColor(rgb(0, value2, 0))
                    text3.setTextColor(rgb(0, 0, value3))

                    surface1.setBackgroundColor(rgb(save1[1].toInt(),save1[2].toInt(),save1[3].toInt()))



                    spin.visibility = View.INVISIBLE
                }
                if (selectedItem == save2[0]) {



                    spin.visibility = View.INVISIBLE
                }
                if (selectedItem == save3[0]) {




                    spin.visibility = View.INVISIBLE
                }


            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }*/

    } // End of on_Create

    //***************************************************************
    // Method to expand menu bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    //spinner.onItemSelectedListener = object : OnItemSelectedListener {
    /*
    fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            val selectedItem = parent.getItemAtPosition(position).toString()

            if (selectedItem == save1[0]) {

                //val spin = spinner.findViewById<Spinner>(R.id.spinner)
                //spin.visibility = View.VISIBLE

                //names[0] = "cool"
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

                textB1.text = "$value1"
                textB2.text = "$value2"
                textB3.text = "$value3"

                text1.setTextColor(rgb(value1, 0, 0))
                text2.setTextColor(rgb(0, value2, 0))
                text3.setTextColor(rgb(0, 0, value3))

                surface1.setBackgroundColor(rgb(save1[1].toInt(),save1[2].toInt(),save1[3].toInt()))



                ///spin.visibility = View.INVISIBLE
            }
            if (selectedItem == save2[0]) {



                //spin.visibility = View.INVISIBLE
            }
            if (selectedItem == save3[0]) {




                //spin.visibility = View.INVISIBLE
            }


        } // to close the onItemSelected
*/
    //***************************************************************
    // Method to make each buttons do something
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        //**********************************************************
        // Save button
        R.id.save -> {

            var textField = input.text
            var saveC = this.findViewById<Button>(R.id.confirm)
            //*********************************************
            //val spin = spinner.findViewById<Spinner>(R.id.spinner)
            //val adapter = ArrayAdapter (
                //this, android.R.layout.simple_spinner_item, names
            //)

            //***************************************************


            input.visibility = View.VISIBLE
            saveC.visibility = View.VISIBLE

            saveC.setOnClickListener {

                var saveS = button.findViewById<Button>(R.id.button)


                save1[0] = textField.toString()
                //val saveS = Toast.makeText(applicationContext, "$save1[0]" + " saved", Toast.LENGTH_LONG)
                //saveS.show()

                // save each value to array slot for rgb format
                //save1[0] = colorName
                save1[1] = value1.toString()
                save1[2] = value2.toString()
                save1[3] = value3.toString()

                input.visibility = View.INVISIBLE
                saveC.visibility = View.INVISIBLE
                //spin.visibility = View.VISIBLE
                saveS.setText(save1[0])

            }

            true
        }

        //**********************************************************
        // load button
        R.id.load -> {

            var saveS = button.findViewById<Button>(R.id.button)


            saveS.visibility = View.VISIBLE

            saveS.setOnClickListener {
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

                saveS.visibility = View.INVISIBLE


            }

            //var saveS = button.findViewById<Button>(R.id.button)


            //var spin = spinner.findViewById<Spinner>(R.id.spinner)
            //spin.visibility = View.VISIBLE
            //spin.setOnClickListener {
               // when("") {
                //    "new1" -> spin.visibility = View.INVISIBLE
                //    "new2" ->Toast.makeText(applicationContext," saved", Toast.LENGTH_LONG)
                //}

            //}



/*

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
*/
            true
        }

        //**********************************************************
        /*
        R.id.clear -> {

            val spin = spinner.findViewById<Spinner>(R.id.spinner)
            spin.visibility = View.VISIBLE

            //names[0] = "cool"
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
*/
        //**********************************************************

        /*
        R.id.l3 -> {

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
        }*/

        //**********************************************************

        /*R.id.d1 -> {

            save1[0] = "new"
            save1[1] = "0"
            save1[2] = "0"
            save1[3] = "0"



            true
        }
*/
        //**********************************************************
        /*
        R.id.d2 -> {

            save2[0] = "new"
            save2[1] = "0"
            save2[2] = "0"
            save2[3] = "0"



            true
        }
*/
        //**********************************************************
        /*
        R.id.d3 -> {

            save3[0] = "new"
            save3[1] = "0"
            save3[2] = "0"
            save3[3] = "0"



            true
        }
*/
        //**********************************************************
        // if action was not recognized, invoke super class

        else -> {
            super.onOptionsItemSelected(item)
        }

        //*****************_End of button commands_*****************

    } // end on_Option_Item_Selected


    //**************************************************************

}// end of main class
