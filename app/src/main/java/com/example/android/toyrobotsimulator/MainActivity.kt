package com.example.android.toyrobotsimulator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var areButtonsEnabled = false
    private lateinit var toyRobot: ToyRobot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUi()
    }

    /**
     * Helper method to initialize the UI
     */
    private fun initUi() {

        val adapter = ArrayAdapter.createFromResource(
                this,
                R.array.compass_points,
                android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        compassPointsSpinner.adapter = adapter


        placeButton.setOnClickListener {
            if (xCoordinateEditText.text.toString().toInt() < TABLE_SIZE
                    && yCoordinateEditText.text.toString().toInt() < TABLE_SIZE) {

                enableTheButtons()
                val compassPointString = compassPointsSpinner.selectedItem.toString()
                val coordinate = Coordinate(
                        xCoordinateEditText.text.toString().toInt(),
                        yCoordinateEditText.text.toString().toInt())

                toyRobot = ToyRobot(coordinate, CompassPoint.toCompassPoint(compassPointString), TABLE_SIZE)
            } else {
                Toast.makeText(this,
                        getString(R.string.error_invalid_action),
                        Toast.LENGTH_SHORT)
                        .show()
            }
        }


        leftButton.setOnClickListener { toyRobot.left() }
        rightButton.setOnClickListener { toyRobot.right() }
        moveButton.setOnClickListener {
            if (!toyRobot.move()) {
                Toast.makeText(this, getString(R.string.error_invalid_action), Toast.LENGTH_SHORT)
                        .show()
            }
        }
        reportButton.setOnClickListener {
            Toast.makeText(this,
                    "X: ${toyRobot.coordinate.x}, Y:${toyRobot.coordinate.y}, ${toyRobot.facing}",
                    Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Helper method to enable the movement buttons
     */
    private fun enableTheButtons() {

        if (areButtonsEnabled) return

        moveButton.isEnabled = true
        reportButton.isEnabled = true
        leftButton.isEnabled = true
        rightButton.isEnabled = true
    }

    companion object {
        const val TABLE_SIZE = 5
    }
}
