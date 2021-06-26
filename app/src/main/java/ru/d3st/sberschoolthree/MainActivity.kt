package ru.d3st.sberschoolthree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private var etvRussian: EditText? = null
    private var etvEnglish: EditText? = null

    private var btnOnRussian: Button? = null
    private var btnOnEnglish: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etvRussian = findViewById(R.id.etvRussian)
        etvEnglish = findViewById(R.id.etvEnglish)

        btnOnEnglish = findViewById(R.id.btn_english)
        btnOnRussian = findViewById(R.id.btn_rus)

        btnOnEnglish?.setOnClickListener {
            val textRussian = etvRussian?.text.toString()
            val textLatin = transliterateFromCyrilicToLatin(textRussian)

            etvEnglish?.setText(textLatin)
        }
        btnOnRussian?.setOnClickListener {
            val textEnglish = etvEnglish?.text.toString()
            val textRussian = transliterateFromLatinToCyrillic(textEnglish)
            etvRussian?.setText(textRussian)
        }

    }
}