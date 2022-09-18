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

        putCounter()
        findViewById<Button>(R.id.button_roll).setOnClickListener {
            counter++
            switchTextViews()
        }
    }

    private fun putCounter() = setCurrent(counter.toString())

    private fun setCurrent(input: String) {
        for (textView in textViews[currentIndex]) {
            textView.text = input
        }
    }

    private fun switchTextViews() {
        clearCurrent()
        currentIndex = (currentIndex + 1) % textViews.size
        putCounter()
    }

    private fun clearCurrent() = setCurrent("")
}