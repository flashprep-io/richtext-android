package io.flashprep.android.richtextlibrary

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.JsonObject
import io.flashprep.android.richtexteditor.htmltoquilldelta.HtmlToQuillDelta
import io.flashprep.android.richtexteditor.richTextLibrary
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    private lateinit var richTextEditor: richTextLibrary
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLibrary()
        bindView()
    }


    private fun setBold() {
        richTextEditor.setBold()
    }

    private fun setItalic() {
        richTextEditor.setItalic()
    }

    private fun setUnderline() {
        richTextEditor.setUnderline()
    }

    private fun setSubscipt() {
        richTextEditor.setSubscript()
    }

    private fun setSuperscript() {
        richTextEditor.setSuperscript()
    }

    private fun setStrikethrough() {
        richTextEditor.setStrikeThrough()
    }

    private fun insertImage() {
        richTextEditor.insertImage(
            "https://raw.githubusercontent.com/wasabeef/art/master/chip.jpg",
            "dachshund", 320
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

}
