package io.flashprep.android.richtexteditor.htmltoquilldelta

import com.google.gson.JsonArray
import com.google.gson.JsonObject

object HtmlToQuillDelta {
    private const val EMPTY_STRING = ""
    private var isBold = false
    private var isItalic = false
    private var isUnderLine = false
    private var isStrike = false
    private var opJsonArray = JsonArray()
    private var deltaJsonObject = JsonObject()


    fun getQuillDelta(htmlString: String) : JsonObject {
        opJsonArray = JsonArray()
        deltaJsonObject = JsonObject()
        var htmlTag = EMPTY_STRING
        var currentSentence = EMPTY_STRING
        var tagOpened = false
        var tagClosed = false

        for (i in htmlString.indices) {
            if (htmlString[i] == HtmlTags.OPENING_TAG) {
                tagOpened = true
            } else if (htmlString[i] == HtmlTags.CLOSING_TAG) {
                tagOpened = false
                tagClosed = true
            }

            if (tagOpened) {   /*IF TAG OPENED, ADD HTML STRING TO HTML TAG AND CONVERT CURRENT SENTENCE TO JSON OBJECT*/
                htmlTag += htmlString[i]

                if (currentSentence != EMPTY_STRING) {
                    getJsonObjectOfCurrentSentence(currentSentence)
                    currentSentence = EMPTY_STRING
                }
            } else if (tagClosed) {   /*IF TAG CLOSED, ADD HTML STRING TO HTML TAG, CHECK FOR TAG AND CLOSE THE TAG*/
                htmlTag += htmlString[i]
                checkForTag(htmlTag)
                htmlTag = EMPTY_STRING
                tagClosed = false
            } else {   /*IF NEITHER TAG IS OPENED OR CLOSED, KEEP ADDING HTML STRING TO CURRENT SENTENCE*/
                currentSentence += htmlString[i]
            }
        }

        if (currentSentence != EMPTY_STRING) {
            getJsonObjectOfCurrentSentence(currentSentence)
            currentSentence = EMPTY_STRING
        }
        addJsonArrayToJsonObject()
        return deltaJsonObject
    }

    /**
     * CHECKS FOR THE TAGS AND ALTERS THE ATTRIBUTES ACCORDINGLY.
     */
    private fun checkForTag(htmlTag: String) {
        when (htmlTag) {
            HtmlTags.BOLD_TAG_START -> {
                isBold = true
            }
            HtmlTags.BOLD_TAG_END -> {
                isBold = false
            }
            HtmlTags.ITALIC_TAG_START -> {
                isItalic = true
            }
            HtmlTags.ITALIC_TAG_END -> {
                isItalic = false
            }
            HtmlTags.UNDER_LINE_TAG_START -> {
                isUnderLine = true
            }
            HtmlTags.UNDER_LINE_TAG_END -> {
                isUnderLine = false
            }
            HtmlTags.STRIKE_THROUGH_TAG_START -> {
                isStrike = true
            }
            HtmlTags.STRIKE_THROUGH_TAG_END -> {
                isStrike = false
            }
        }
    }

    /**
     * CREATES THE JSON OBJECT OF THE CURRENT SENTENCE IN QUILL DELTA FORMAT
     * WITH THE HELP OF ATTRIBUTES FROM THE HTML.
     */
    private fun getJsonObjectOfCurrentSentence(currentSentence: String) {
        val attributes = JsonObject()
        attributes.addProperty(Attributes.BOLD, isBold)
        attributes.addProperty(Attributes.ITALIC, isItalic)
        attributes.addProperty(Attributes.UNDER_LINE, isUnderLine)
        attributes.addProperty(Attributes.STRIKE_THROUGH, isStrike)


        val op = JsonObject()
        op.addProperty(Attributes.INSERT, currentSentence)
        op.add(Attributes.ATTRIBUTES, attributes)

        opJsonArray.add(op)
    }

    /**
     * ADDS THE COMPLETE JSON ARRAY INTO THE FINAL JSON OBJECT WITH OPS ATTRIBUTE.
     */
    private fun addJsonArrayToJsonObject() {
        deltaJsonObject.add(Attributes.OPS, opJsonArray)
    }
}