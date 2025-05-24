package uws.ac.uk.checkers

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {

    lateinit var onePlayerButton: Button
    lateinit var twoPlayersButton: Button
    lateinit var instructionsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        onePlayerButton = findViewById(R.id.onePlayerButton)
        onePlayerButton.setOnClickListener {
            val intent = Intent (this, OnePlayerMenu::class.java)
            startActivity(intent)
        }
        twoPlayersButton = findViewById(R.id.twoPlayersButton)
        twoPlayersButton.setOnClickListener {
            val intent = Intent (this, TwoPlayersMenu::class.java)
            startActivity(intent)
        }


        instructionsButton = findViewById(R.id.instructionsButton)
        instructionsButton.setOnClickListener {
            val intent = Intent (this, Instructions::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}