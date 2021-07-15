package ru.d3st.sberschoolthree

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

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

        btnOnRussian = findViewById<Button>(R.id.btn_rus).apply {
            setOnClickListener {
                val textEnglish = etvEnglish?.text.toString()
                val textRussian = transliterateFromLatinToCyrillic(textEnglish)
                etvRussian?.setText(textRussian)
            }

        }

        btnOnEnglish = findViewById<Button>(R.id.btn_english).apply {
            setOnClickListener {
                val textRussian = etvRussian?.text.toString()
                val textLatin = transliterateFromCyrillicToLatin(textRussian)
                etvEnglish?.setText(textLatin)
            }

        }
    }
}