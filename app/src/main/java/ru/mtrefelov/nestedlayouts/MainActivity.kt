package ru.mtrefelov.nestedlayouts

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textViews: List<List<TextView>>
    private var counter = 1
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViews = listOf(
            listOf(
                R.id.textView_top_left,
                R.id.textView_middle_upper,
                R.id.textView_bottom_left
            ),
            listOf(
                R.id.textView_top_middle,
                R.id.textView_middle_middle,
                R.id.textView_bottom_right
            ),
            listOf(
                R.id.textView_top_right,
                R.id.textView_middle_bottom,
                R.id.textView_bottom_bottom
            )
        ).map { it.map(::findViewById) }

        putCounterInActiveTextViews()
        findViewById<Button>(R.id.button_roll).setOnClickListener {
            counter++
            switchCurrentTextViews()
        }
    }

    private fun putCounterInActiveTextViews() = setTextInCurrentTextViews(counter.toString())

    private fun setTextInCurrentTextViews(input: String) {
        for (textView in textViews[currentIndex]) {
            textView.text = input
        }
    }

    private fun switchCurrentTextViews() {
        clearCurrentTextViews()
        currentIndex = (currentIndex + 1) % textViews.size
        putCounterInActiveTextViews()
    }

    private fun clearCurrentTextViews() = setTextInCurrentTextViews("")
}