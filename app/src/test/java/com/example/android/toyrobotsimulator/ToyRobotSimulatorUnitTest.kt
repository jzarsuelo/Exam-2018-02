package com.example.android.toyrobotsimulator

import android.text.method.Touch
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ToyRobotSimulatorUnitTest {

    private lateinit var toyRobot: ToyRobot

    @Before
    fun init() {
        toyRobot = ToyRobot(Coordinate(0, 0), CompassPoint.NORTH, MainActivity.TABLE_SIZE)
    }

    @Test
    fun moveNorth_4() {
        toyRobot.move()
        toyRobot.move()
        toyRobot.move()
        toyRobot.move()

        assertEquals(4, toyRobot.coordinate.y)
        assertEquals(0, toyRobot.coordinate.x)
        assertEquals(CompassPoint.NORTH, toyRobot.facing)
    }

    @Test
    fun moveSouth_1() {
        toyRobot.right()
        toyRobot.right()
        toyRobot.move()

        assertEquals(0, toyRobot.coordinate.y)
        assertEquals(0, toyRobot.coordinate.x)
        assertEquals(CompassPoint.SOUTH, toyRobot.facing)
    }

    @Test
    fun moveWest_1() {
        toyRobot.left()
        toyRobot.move()

        assertEquals(0, toyRobot.coordinate.y)
        assertEquals(0, toyRobot.coordinate.x)
        assertEquals(CompassPoint.WEST, toyRobot.facing)
    }

    @Test
    fun moveToCenter() {
        toyRobot.move()
        toyRobot.move()

        toyRobot.right()

        toyRobot.move()
        toyRobot.move()

        assertEquals(2, toyRobot.coordinate.y)
        assertEquals(2, toyRobot.coordinate.x)
    }
}
