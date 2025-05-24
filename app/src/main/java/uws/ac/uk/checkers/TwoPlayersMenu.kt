package uws.ac.uk.checkers

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class TwoPlayersMenu : AppCompatActivity() {

    lateinit var toolbar: MaterialToolbar
    lateinit var newGameButton: Button
    lateinit var continueGameButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_two_players_menu)

        toolbar = findViewById(R.id.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    finish()
                    true
                }

                R.id.leave -> {
                    showExitConfirmationDialog()
                    true
                }
                else -> false
            }

        }

        newGameButton = findViewById(R.id.newGameButton)
        newGameButton.setOnClickListener {
            val intent = Intent(this, TwoPlayersGame::class.java)
            startActivity(intent)
        }

        continueGameButton = findViewById(R.id.continueGameButton)

        val hasSavedGame= checkSavedGame()
        continueGameButton.isEnabled=hasSavedGame

        continueGameButton.text = if (hasSavedGame) "Continue Game" else "No saved game"

        continueGameButton.setOnClickListener {
            if (hasSavedGame) {
                startActivity(Intent(this, TwoPlayersGame::class.java))

            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showExitConfirmationDialog (){
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Exit Game")
        builder.setMessage("Are you sure you want to exit the game?")
        builder.setPositiveButton("Yes") { dialog: DialogInterface, _: Int ->
            finishAffinity()
        }
        builder.setNegativeButton("No") { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun checkSavedGame(): Boolean {
        return false
    }
}