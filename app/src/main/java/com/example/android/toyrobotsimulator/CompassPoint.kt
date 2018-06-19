package com.example.android.toyrobotsimulator

enum class CompassPoint(private val point: String) {
    NORTH("North"),
    EAST("East"),
    SOUTH("South"),
    WEST("West");

    companion object {

        fun toCompassPoint(point: String): CompassPoint {
            return when (point) {
                NORTH.point -> NORTH
                EAST.point -> EAST
                SOUTH.point -> SOUTH
                else -> WEST
            }
        }

    }
}