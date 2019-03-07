package com.example.assignment_two

import android.app.Activity
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
import android.content.Intent




//*****************************************************************
// Main class
class MainActivity : AppCompatActivity() {

    var value1 = 0 // variable to set surface view color  ( Red )
    var value2 = 0 // variable to set surface view color  ( Green )
    var value3 = 0 // variable to set surface view color  ( Bl:ue )

    var save1 = arrayOf("new1", "0", "0", "0") // array variable for save button values
    var save2 = arrayOf("new1", "0", "0", "0") // array variable for save button values
    var save3 = arrayOf("new1", "0", "0", "0") // array variable for save button values


    var bool1 = false
    var bool2 = false
    var bool3 = false

    //val slot1 = button.findViewById<Button>(R.id.button1)
    //val slot2 = button.findViewById<Button>(R.id.button)
   // val slot3 = button.findViewById<Button>(R.id.button3)

    //verride fun Inten



    // initialize app
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)  // Menu item support

        val button = findViewById<Button>(R.id.done)




        //************************************************************


        val text1 = this.findViewById<TextView>(R.id.textB1) // text field to show seek values
        val text2 = this.findViewById<TextView>(R.id.textB2) // text field to show seek values
        val text3 = this.findViewById<TextView>(R.id.textB3) // text field to show seek values

        val seekBar1 = this.findViewById<SeekBar>(R.id.seekBar1) // seek bar var
        val seekBar2 = this.findViewById<SeekBar>(R.id.seekBar2) // seek bar var
        val seekBar3 = this.findViewById<SeekBar>(R.id.seekBar3) // seek bar var

        var slot1 = button.findViewById<Button>(R.id.button1)
        var slot2 = button.findViewById<Button>(R.id.button)
        var slot3 = button.findViewById<Button>(R.id.button3)


        // ***********************************************************************

        seekBar1.progress = value1 // set variable to seek bar value
        seekBar2.progress = value2 // set variable to seek bar value
        seekBar3.progress = value3 // set variable to seek bar value

        text1.text = value1.toString() // convert to string just in case
        text2.text = value2.toString() // convert to string just in case
        text3.text = value3.toString() // convert to string just in case

        val surface1 = this.surfaceView // create surface variable
        val result1 = arrayListOf(0,0,0)

        button.setOnClickListener {
            result1[0] = value1
            result1[1] = value2
            result1[2] = value3

            val returnIntent = Intent()
            returnIntent.putIntegerArrayListExtra("result", result1)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

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
/*
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val button = findViewById<Button>(R.id.done)
        button.visibility = View.INVISIBLE


    }*/

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

            var slot1 = this.findViewById<Button>(R.id.button1)
            var slot2 = this.findViewById<Button>(R.id.button)
            var slot3 = this.findViewById<Button>(R.id.button3)




            saveC.setOnClickListener {

                if (bool1 == false) {

                    // saveC.setOnClickListener {

                    //var slot1 = button.findViewById<Button>(R.id.button1)


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
                    slot1.setText(save1[0])
                    bool1 = true

                } else if (bool2 == false) {

                    // saveC.setOnClickListener {

                    //var slot2 = button.findViewById<Button>(R.id.button)


                    save2[0] = textField.toString()
                    //val saveS = Toast.makeText(applicationContext, "$save1[0]" + " saved", Toast.LENGTH_LONG)
                    //saveS.show()

                    // save each value to array slot for rgb format
                    //save1[0] = colorName
                    save2[1] = value1.toString()
                    save2[2] = value2.toString()
                    save2[3] = value3.toString()

                    input.visibility = View.INVISIBLE
                    saveC.visibility = View.INVISIBLE
                    //spin.visibility = View.VISIBLE
                    slot2.setText(save2[0])
                    bool2 = true

                } else {

                    // saveC.setOnClickListener {

                    //var slot3 = button.findViewById<Button>(R.id.button3)


                    save3[0] = textField.toString()
                    //val saveS = Toast.makeText(applicationContext, "$save1[0]" + " saved", Toast.LENGTH_LONG)
                    //saveS.show()

                    // save each value to array slot for rgb format
                    //save1[0] = colorName
                    save3[1] = value1.toString()
                    save3[2] = value2.toString()
                    save3[3] = value3.toString()

                    input.visibility = View.INVISIBLE
                    saveC.visibility = View.INVISIBLE
                    //spin.visibility = View.VISIBLE
                    slot3.setText(save3[ 0])
                    bool3 = true

                }

            }




            true
        }

        //**********************************************************
        // load button
        R.id.load -> {

            var slot1 = this.findViewById<Button>(R.id.button1)
            var slot2 = this.findViewById<Button>(R.id.button)
            var slot3 = this.findViewById<Button>(R.id.button3)


            if ((bool1 == false) && (bool3 == false) ) {

                slot1.visibility = View.VISIBLE

                slot1.setOnClickListener {
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

                    slot1.visibility = View.INVISIBLE

                }


            }
            else if ((bool2 == true) && (bool3 == false)) {
                slot1.visibility = View.VISIBLE
                slot2.visibility = View.VISIBLE

                slot1.setOnClickListener {
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

                    slot1.visibility = View.INVISIBLE
                    slot2.visibility = View.INVISIBLE


                }

                slot2.setOnClickListener {
                    val surface1 = this.surfaceView // create surface variable

                    val text1 = this.findViewById<TextView>(R.id.textB1) // text field to show seek values
                    val text2 = this.findViewById<TextView>(R.id.textB2) // text field to show seek values
                    val text3 = this.findViewById<TextView>(R.id.textB3) // text field to show seek values

                    value1 = save2[1].toInt()
                    value2 = save2[2].toInt()
                    value3 = save2[3].toInt()

                    seekBar1.progress = value1 // set variable to seek bar value
                    seekBar2.progress = value2 // set variable to seek bar value
                    seekBar3.progress = value3 // set variable to seek bar value

                    text1.text = "$value1"
                    text2.text = "$value2"
                    text3.text = "$value3"

                    text1.setTextColor(rgb(value1, 0, 0))
                    text2.setTextColor(rgb(0, value2, 0))
                    text3.setTextColor(rgb(0, 0, value3))

                    surface1.setBackgroundColor(rgb(save2[1].toInt(),save2[2].toInt(),save2[3].toInt()))

                    slot2.visibility = View.INVISIBLE
                    slot1.visibility = View.INVISIBLE

                }



            }

            else {
                slot1.visibility = View.VISIBLE
                slot2.visibility = View.VISIBLE
                slot3.visibility = View.VISIBLE

                slot1.setOnClickListener {
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

                    slot1.visibility = View.INVISIBLE
                    slot2.visibility = View.INVISIBLE
                    slot3.visibility = View.INVISIBLE


                }
                slot2.setOnClickListener {
                    val surface1 = this.surfaceView // create surface variable

                    val text1 = this.findViewById<TextView>(R.id.textB1) // text field to show seek values
                    val text2 = this.findViewById<TextView>(R.id.textB2) // text field to show seek values
                    val text3 = this.findViewById<TextView>(R.id.textB3) // text field to show seek values

                    value1 = save2[1].toInt()
                    value2 = save2[2].toInt()
                    value3 = save2[3].toInt()

                    seekBar1.progress = value1 // set variable to seek bar value
                    seekBar2.progress = value2 // set variable to seek bar value
                    seekBar3.progress = value3 // set variable to seek bar value

                    text1.text = "$value1"
                    text2.text = "$value2"
                    text3.text = "$value3"

                    text1.setTextColor(rgb(value2, 0, 0))
                    text2.setTextColor(rgb(0, value2, 0))
                    text3.setTextColor(rgb(0, 0, value2))

                    surface1.setBackgroundColor(rgb(save2[1].toInt(),save2[2].toInt(),save2[3].toInt()))

                    slot1.visibility = View.INVISIBLE
                    slot2.visibility = View.INVISIBLE
                    slot3.visibility = View.INVISIBLE



                }
                slot3.setOnClickListener {
                    val surface1 = this.surfaceView // create surface variable

                    val text1 = this.findViewById<TextView>(R.id.textB1) // text field to show seek values
                    val text2 = this.findViewById<TextView>(R.id.textB2) // text field to show seek values
                    val text3 = this.findViewById<TextView>(R.id.textB3) // text field to show seek values

                    value1 = save3[1].toInt()
                    value2 = save3[2].toInt()
                    value3 = save3[3].toInt()

                    seekBar1.progress = value1 // set variable to seek bar value
                    seekBar2.progress = value2 // set variable to seek bar value
                    seekBar3.progress = value3 // set variable to seek bar value

                    text1.text = "$value1"
                    text2.text = "$value2"
                    text3.text = "$value3"

                    text1.setTextColor(rgb(value1, 0, 0))
                    text2.setTextColor(rgb(0, value2, 0))
                    text3.setTextColor(rgb(0, 0, value3))

                    surface1.setBackgroundColor(rgb(save3[1].toInt(),save3[2].toInt(),save3[3].toInt()))

                    slot1.visibility = View.INVISIBLE
                    slot2.visibility = View.INVISIBLE
                    slot3.visibility = View.INVISIBLE


                }



            }



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
