package za.iie.historypoe

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FlashcardQuestionActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994.",
        "The Berlin Wall fell in 1989.",
        "World War II ended in 1946.",
        "The Roman Empire fell in 476 AD.",
        "The French Revolution began in 1799."
    ) //(GeeksforGeeks, 2022).//

    private val answers = booleanArrayOf(true, true, false, true, false)
    private var currentIndex = 0
    private var score = 0 //(GeeksforGeeks, 2022).// //(JetBrains, 2024)//

    private lateinit var questionText: TextView
    private lateinit var feedbackText: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard_question)

        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)

        setQuestion()

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
    }

    private fun setQuestion() {
        if (currentIndex < questions.size) {
            questionText.text = questions[currentIndex]
            feedbackText.text = ""
        } else {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("score", score)
            intent.putExtra("questions", questions)
            intent.putExtra("answers", answers)
            startActivity(intent)
            finish()
        }
    } //(JetBrains, 2024).//

    private fun checkAnswer(userAnswer: Boolean) {
        val correct = answers[currentIndex]
        if (userAnswer == correct) {
            feedbackText.text = "Correct!"
            score++
        } else {
            feedbackText.text = "Incorrect"
        } //(JetBrains, 2024).//

        currentIndex++
        trueButton.isEnabled = false
        falseButton.isEnabled = false

        // Move to next question after short delay
        questionText.postDelayed({
            trueButton.isEnabled = true
            falseButton.isEnabled = true
            setQuestion()
        }, 1000)
    }
}
/*
References:
IIE Module Manual, 2024. Kotlin. [Accessed on 10 May].
GeeksforGeeks. (2021). Android App Development with Kotlin. https://www.geeksforgeeks.org/android-app-development-with-kotlin/ [Acccessed 13 May 2025].
Android Developers, 2023. View.OnClickListener. [online] Available at: https://developer.android.com/reference/android/view/View.OnClickListener [Accessed 14 May 2025].
JetBrains, 2024. Kotlin Control Flow: if, when, for, while. [online] Kotlin Documentation. Available at: https://kotlinlang.org/docs/control-flow.html#if-expression [Accessed 14 May 2025].
JetBrains, 2024. Kotlin Arrays. [online] Kotlin Documentation. Available at: https://kotlinlang.org/docs/arrays.html [Accessed 14 May 2025].
GeeksforGeeks, 2022. Kotlin Arrays. [online] Available at: https://www.geeksforgeeks.org/kotlin-arrays/ [Accessed 14 May 2025].

 */