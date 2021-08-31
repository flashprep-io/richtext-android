package io.flashprep.android.richtextlibrary

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.flashprep.android.richtexteditor.richTextLibrary


class MainActivity : AppCompatActivity() {

    private lateinit var richTextEditor : richTextLibrary
    private lateinit var boldButton : Button
    private lateinit var italicButton : Button
    private lateinit var underlineButton : Button
    private lateinit var subscriptButton: Button
    private lateinit var superscriptButton: Button
    private lateinit var strikethroughButton: Button
    private lateinit var addImageButton : Button
    private lateinit var setTextColor : Button
    private lateinit var setBackgroundColor: Button
    private lateinit var setFontSize: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLibrary()
        bindView()
    }


    private fun setBold(){
        richTextEditor.setBold()
    }
    private fun setItalic(){
        richTextEditor.setItalic()
    }
    private fun setUnderline(){
        richTextEditor.setUnderline()
    }
    private  fun setSubscipt(){
        richTextEditor.setSubscript()
    }
    private fun setSuperscript(){
        richTextEditor.setSuperscript()
    }
    private fun setStrikethrough(){
        richTextEditor.setStrikeThrough()
    }
    private fun insertImage( ) {
        richTextEditor.insertImage("https://raw.githubusercontent.com/wasabeef/art/master/chip.jpg",
                "dachshund", 320)
    }
    private fun setTextColor(){
        richTextEditor.setTextColor(Color.BLUE)
    }
    private fun setBackgroundColor(){
        richTextEditor.setBackgroundColor(Color.YELLOW)
    }
    private fun setFontSize(){
        richTextEditor.setFontSize(18)
    }
    private fun setPadding(){
        richTextEditor.setPadding(70,40,10,10)
    }
    private fun setPlaceHoder(){
        richTextEditor.setPlaceholder("Hi, This is it")
    }





    private fun initLibrary(){
        richTextEditor = findViewById(R.id.richTextEditor)
        boldButton = findViewById(R.id.boldButton)
        italicButton = findViewById(R.id.italicButton)
        underlineButton = findViewById(R.id.underlineButton)
        subscriptButton = findViewById(R.id.subscriptButton)
        superscriptButton = findViewById(R.id.superscriptButton)
        strikethroughButton = findViewById(R.id.strikethroughButton)
        addImageButton = findViewById(R.id.addImageButton)
        setTextColor = findViewById(R.id.setTextColor)
        setBackgroundColor = findViewById(R.id.backgroundColor)
        setFontSize = findViewById(R.id.fontsize)

    }
    private fun bindView(){
        boldButton.setOnClickListener {
            setBold()
        }
        italicButton.setOnClickListener{
            setItalic()
        }
        underlineButton.setOnClickListener {
            setUnderline()
        }
        subscriptButton.setOnClickListener{
            setSubscipt()
        }
        superscriptButton.setOnClickListener {
            setSuperscript()
        }
        strikethroughButton.setOnClickListener {
            setStrikethrough()
        }
        addImageButton.setOnClickListener {
            insertImage()
        }
        setTextColor.setOnClickListener {
            setTextColor()
        }
        setBackgroundColor.setOnClickListener {
            setBackgroundColor()
        }
        setFontSize.setOnClickListener {
            setFontSize()
        }
        setPadding()
        setPlaceHoder()




    }



}
