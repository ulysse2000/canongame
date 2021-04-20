package com.example.canongame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class Obstacle (var obstacleDistance: Float, var obstacleDebut: Float, var obstacleFin: Float, var initialObstacleVitesse: Float, var width: Float, var view: CanonView)
{
    val obstacle = RectF(obstacleDistance, obstacleDebut,
        obstacleDistance + width, obstacleFin)
    val obstaclePaint = Paint()
    var obstacleVitesse= initialObstacleVitesse

    fun setRect() {
        obstacle.set(obstacleDistance, obstacleDebut,
            obstacleDistance + width, obstacleFin)
        obstacleVitesse= initialObstacleVitesse
    }

    fun draw(canvas: Canvas) {
        obstaclePaint.color = Color.RED
        canvas.drawRect(obstacle, obstaclePaint)
    }

    fun update(interval: Double) {
        var up = (interval * obstacleVitesse).toFloat()
        obstacle.offset(0f, up)
        if (obstacle.top < 0 || obstacle.bottom > view.screenHeight) {
            obstacleVitesse *= -1
            up = (interval * 3 * obstacleVitesse).toFloat()
            obstacle.offset(0f, up)
        }
    }

    fun resetObstacle() {
        obstacleVitesse = initialObstacleVitesse
        obstacle.set(obstacleDistance, obstacleDebut,
            obstacleDistance + width, obstacleFin)
    }
}