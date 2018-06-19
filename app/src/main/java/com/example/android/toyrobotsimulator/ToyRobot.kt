package com.example.android.toyrobotsimulator


class ToyRobot(
        var coordinate: Coordinate,
        var facing: CompassPoint,
        private val squareSize: Int
) {

    fun move(): Boolean {
        var newCoordinate = coordinate.copy()
        when (facing) {
            CompassPoint.NORTH -> newCoordinate.y++
            CompassPoint.EAST -> newCoordinate.x++
            CompassPoint.SOUTH -> newCoordinate.y--
            CompassPoint.WEST -> newCoordinate.x--
        }
        return verifyMovement(newCoordinate)
    }

    private fun verifyMovement(newCoordinate: Coordinate): Boolean {
        return if (newCoordinate.x in 0..(squareSize - 1) && newCoordinate.y in 0..(squareSize - 1)) {
            coordinate = newCoordinate
            true
        } else {
            false
        }
    }

    fun left() {
        facing = when (facing) {
            CompassPoint.NORTH -> CompassPoint.EAST
            CompassPoint.EAST -> CompassPoint.SOUTH
            CompassPoint.SOUTH -> CompassPoint.WEST
            else -> CompassPoint.NORTH
        }
    }

    fun right() {
        facing = when (facing) {
            CompassPoint.NORTH -> CompassPoint.EAST
            CompassPoint.EAST -> CompassPoint.SOUTH
            CompassPoint.SOUTH -> CompassPoint.WEST
            else -> CompassPoint.NORTH
        }
    }
}