/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.orange.accessibilitystatementlibrary

import android.content.Context
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream

class StatementXMLParser(context: Context) {

    private val XML_DATE = "audit_date"
    private val XML_REFERENTIAL = "referential"
    private val XML_REFERENTIAL_NAME = "name"
    private val XML_REFERENTIAL_VERSION = "version"
    private val XML_REFERENTIAL_LEVEL = "level"
    private val XML_RESULTS = "pages_results"
    private val XML_SCREEN_AUDITED = "page"
    private val XML_ATTRIBUTE_CONFORMITY = "conformity"
    private val XML_ATTRIBUTE_SCREEN_NAME = "name"
    private val XML_TECHNO = "technology"
    private val XML_TITLE = "title"
    private val XML_DETAILS = "details"

    private val FILE_NAME = "accessibility_result.xml"

    private lateinit var parser: XmlPullParser
    private var mContext: Context

    private val accessibilityStatement = AccessibilityStatement()

    init {
        mContext = context
    }

    fun getAccessibilityStatementFromXML(): AccessibilityStatement {
        parseXML()
        processParsing()
        return accessibilityStatement
    }

    private fun parseXML() {
        val parserFactory = XmlPullParserFactory.newInstance()
        val inputStream: InputStream = mContext.assets.open(FILE_NAME)

        parser = parserFactory.newPullParser()
        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
        parser.setInput(inputStream, null)
    }

    private fun processParsing() {
        var referentialStarted = false
        var detailsStarted = false

        var eventType = parser.eventType

        while (eventType != XmlPullParser.END_DOCUMENT) {
            var eltName = ""

            if (eventType == XmlPullParser.START_TAG) {
                eltName = parser.name

                when (eltName) {
                    XML_DATE -> parseDate()
                    XML_TECHNO -> parseTechno()
                    XML_REFERENTIAL -> referentialStarted = true
                    XML_REFERENTIAL_NAME -> if (referentialStarted) parseReferentialName()
                    XML_REFERENTIAL_VERSION -> if (referentialStarted) parseReferentialVersion()
                    XML_REFERENTIAL_LEVEL -> {
                        if (referentialStarted) {
                            parseReferentialLevel()
                            referentialStarted = false
                        }
                    }
                    XML_RESULTS -> parseResults()
                    XML_DETAILS -> detailsStarted = true
                    XML_TITLE -> if (!detailsStarted) parseTitle()
                }
            }
            eventType = parser.next()
        }
    }

    private fun parseDate() {
        accessibilityStatement.date = parser.nextText()
    }

    private fun parseTechno() {
        val technology = parser.nextText()
        if (accessibilityStatement.technologies == null || accessibilityStatement.technologies.length == 0) {
            accessibilityStatement.technologies = "$technology"
        } else {
            accessibilityStatement.technologies = accessibilityStatement.technologies + ", $technology"
        }
    }

    private fun parseReferentialName() {
        val name = parser.nextText()
        accessibilityStatement.referential = "$name"
    }

    private fun parseReferentialVersion() {
        val version = parser.nextText()
        accessibilityStatement.referential = accessibilityStatement.referential + " $version"
    }

    private fun parseReferentialLevel() {
        val level = parser.nextText()
        accessibilityStatement.referential = accessibilityStatement.referential + " $level"
    }

    private fun parseResults() {
        accessibilityStatement.resultScore = parser.getAttributeValue(null, XML_ATTRIBUTE_CONFORMITY)
    }

    private fun parseTitle() {
        accessibilityStatement.title = parser.nextText()
        accessibilityStatement.title.toString()
    }


}