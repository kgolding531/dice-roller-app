package com.example.dicerollerapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.dicerolling)

        // find the button in the layout
        val button: Button = findViewById(R.id.button)

        // set click listener for button click
        button.setOnClickListener {
            mp.start()
            rollDice()
        }
    }

    // code to roll dice and display results
    private fun rollDice() {
        val dice1 = Dice(6)
        val diceRoll1 = dice1.roll()

        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()

        val image1: ImageView = findViewById(R.id.dice1)
        val image2: ImageView = findViewById(R.id.dice2)

        val drawableResource1 = when(diceRoll1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when(diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // update image views with dice images
        image1.setImageResource(drawableResource1)
        image2.setImageResource(drawableResource2)

        // update the screen wth (total) results
        val sum = diceRoll1 + diceRoll2
        val textView: TextView = findViewById(R.id.textView)

        if (diceRoll1 == diceRoll2) {
            textView.text = "You rolled ${sum.toString()} in total. Nice double!"
        } else {
            textView.text = "You rolled ${sum.toString()} in total"
        }
    }
}

class Dice (private val numberOfSides: Int) {

    // function to return randomly rolled number
    fun roll(): Int {
        return (1..numberOfSides).random()
    }
}