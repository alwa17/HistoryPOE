package za.iie.historypoe

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    private lateinit var scoreText: TextView
    private lateinit var feedbackText: TextView
    private lateinit var reviewButton: Button
    private lateinit var reviewText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        scoreText = findViewById(R.id.scoreText)
        feedbackText = findViewById(R.id.feedbackText)
        reviewButton = findViewById(R.id.reviewButton)
        reviewText = findViewById(R.id.reviewText)

        val score = intent.getIntExtra("score", 0)
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        scoreText.text = "You scored $score / 5"

        feedbackText.text = if (score >= 3) "Great job!" else "Keep practising!" // (Android Developers, 2023; GeeksforGeeks, 2021).

        reviewButton.setOnClickListener {
            val builder = StringBuilder()
            for (i in questions!!.indices) {
                builder.append("Q${i + 1}: ${questions[i]}\n")
                builder.append("Correct Answer: ${if (answers!![i]) "True" else "False"}\n\n")
            }
            reviewText.text = builder.toString()
            reviewText.visibility = TextView.VISIBLE
        }
    }
} //(JetBrains, 2024)
/*
Reference List:
IIE Module Manual, 2024. Kotlin. [Accessed on 10 May].
JetBrains, 2024. Kotlin Control Flow: for Loops. [online] Kotlin Documentation. Available at: https://kotlinlang.org/docs/control-flow.html#for-loops [Accessed 16 May 2025].
GeeksforGeeks, 2022. Kotlin StringBuilder. [online] Available at: https://www.geeksforgeeks.org/kotlin-stringbuilder/ [Accessed 16 May 2025].
JetBrains, 2024. Kotlin Control Flow: if Expressions. [online] Kotlin Documentation. Available at: https://kotlinlang.org/docs/control-flow.html#if-expression [Accessed 16 May 2025].
Android Developers, 2023. TextView. [online] Available at: https://developer.android.com/reference/android/widget/TextView [Accessed 17 May 2025].
GeeksforGeeks, 2021. Kotlin Android – TextView. [online] Available at: https://www.geeksforgeeks.org/kotlin-android-textview/ [Accessed 17 May 2025].
 */
