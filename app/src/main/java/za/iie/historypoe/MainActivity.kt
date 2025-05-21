package za.iie.historypoe


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.startButton).setOnClickListener {
            startActivity(Intent(this, FlashcardQuestionActivity::class.java))
        }
    }
}
/*
IIE Module Manual, 2024. Kotlin. [Accessed on 10 May].
Android Developers, 2023. View.OnClickListener. [online] Available at: https://developer.android.com/reference/android/view/View.OnClickListener [Accessed 14 May 2025].

 */