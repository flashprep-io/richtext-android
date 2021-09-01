package io.flashprep.android.richtextlibrary

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.flashprep.android.richtexteditor.htmltoquilldelta.HtmlToQuillDelta
import io.flashprep.android.richtexteditor.RichTextLibrary


class MainActivity : AppCompatActivity() {

    private lateinit var richTextEditor: RichTextLibrary
    private lateinit var boldButton: Button
    private lateinit var italicButton: Button
    private lateinit var underlineButton: Button
    private lateinit var subscriptButton: Button
    private lateinit var superscriptButton: Button
    private lateinit var strikethroughButton: Button
    private lateinit var addImageButton: Button
    private lateinit var getHtml: Button
    private lateinit var getDetla: Button
    private var htmlData = ""

    private var isBold = false
    private var isItalic = false
    private var isUnderLine = false
    private var isSubScript = false
    private var isSuperScript = false
    private var isStrikeThrough = false
    private var image = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLibrary()
        bindView()
        focusEditor()
    }


    private fun setBold() {
        isBold = !isBold
        if(isBold){
            boldButton.setTextColor(getColor(R.color.teal_200))
        }else{
            boldButton.setTextColor(getColor(R.color.white))
        }
        richTextEditor.setBold()
    }

    private fun setItalic() {
        isItalic = !isItalic
        if(isItalic){
            italicButton.setTextColor(getColor(R.color.teal_200))
        }else{
            italicButton.setTextColor(getColor(R.color.white))
        }
        richTextEditor.setItalic()
    }

    private fun setUnderline() {
        isUnderLine = !isUnderLine
        if(isUnderLine){
            underlineButton.setTextColor(getColor(R.color.teal_200))
        }else{
            underlineButton.setTextColor(getColor(R.color.white))
        }
        richTextEditor.setUnderline()
    }

    private fun setSubscipt() {
        isSubScript = !isSubScript
        if(isSubScript){
            subscriptButton.setTextColor(getColor(R.color.teal_200))
            richTextEditor.setSubscript()
        }else{
            subscriptButton.setTextColor(getColor(R.color.white))
            richTextEditor.setSubscript()
            richTextEditor.setSubscript()
        }
    }

    private fun setSuperscript() {
        isSuperScript = !isSuperScript
        if(isSuperScript){
            superscriptButton.setTextColor(getColor(R.color.teal_200))
            richTextEditor.setSuperscript()
        }else{
            superscriptButton.setTextColor(getColor(R.color.white))
            richTextEditor.setSuperscript()
            richTextEditor.setSuperscript()
        }
    }

    private fun setStrikethrough() {
        isStrikeThrough = !isStrikeThrough
        if(isStrikeThrough){
            strikethroughButton.setTextColor(getColor(R.color.teal_200))
        }else{
            strikethroughButton.setTextColor(getColor(R.color.white))
        }
        richTextEditor.setStrikeThrough()
    }

    private fun insertImage() {
        richTextEditor.insertImage(
            "http://flashprep-media-aps1.s3.ap-south-1.amazonaws.com/release/000-create-default/01.jpg",
            "demo image"
        )
    }

    private fun setTextColor() {
        richTextEditor.setTextColor(Color.BLUE)
    }

    private fun setBackgroundColor() {
        richTextEditor.setBackgroundColor(Color.YELLOW)
    }

    private fun setFontSize() {
        richTextEditor.setFontSize(18)
    }

    private fun setPadding() {
        richTextEditor.setPadding(70, 40, 10, 10)
    }

    private fun setPlaceHoder() {
        richTextEditor.setPlaceholder("Hi, This is it")
    }


    private fun initLibrary() {
        richTextEditor = findViewById(R.id.richTextEditor)
        boldButton = findViewById(R.id.boldButton)
        italicButton = findViewById(R.id.italicButton)
        underlineButton = findViewById(R.id.underlineButton)
        subscriptButton = findViewById(R.id.subscriptButton)
        superscriptButton = findViewById(R.id.superscriptButton)
        strikethroughButton = findViewById(R.id.strikethroughButton)
        addImageButton = findViewById(R.id.addImageButton)
        getHtml = findViewById(R.id.getHtml)
        getDetla = findViewById(R.id.getDetla)

    }

    private fun bindView() {
        boldButton.setOnClickListener {
            setBold()
        }
        italicButton.setOnClickListener {
            setItalic()
        }
        underlineButton.setOnClickListener {
            setUnderline()
        }
        subscriptButton.setOnClickListener {
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

        getHtml.setOnClickListener {
            getHtml()
        }

        getDetla.setOnClickListener {
            getQuillDelta()
        }
    }

    private fun getHtml(){
        htmlData = richTextEditor.html
        println("---------: ${htmlData}")
    }

    private fun getQuillDelta(){
        val quillObject  = HtmlToQuillDelta.getQuillDelta(richTextEditor.html)
        println("------${quillObject}")
    }

    private fun focusEditor(){
        //richTextEditor.focusEditor()
    }



}
