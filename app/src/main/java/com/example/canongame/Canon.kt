package com.example.canongame

import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.PointF

class Canon (var canonBaseRadius: Float, var canonLongueur: Float, hauteur: Float, var largeur: Float, val view: CanonView) {
    val canonPaint = Paint()
    var finCanon = PointF(canonLongueur, hauteur)

    fun draw(canvas: Canvas) {
        canonPaint.strokeWidth = largeur * 1.5f
        canvas.drawLine(0f, view.screenHeight/2, finCanon.x,
            finCanon.y, canonPaint)
        canvas.drawCircle(0f, view.screenHeight/2, canonBaseRadius,
            canonPaint)
    }

    fun setFinCanon(hauteur: Float) {
        finCanon.set(canonLongueur, hauteur)
    }

    fun align(angle: Double) {
        finCanon.x = (canonLongueur * Math.sin(angle)).toFloat()
        finCanon.y = (-canonLongueur * Math.cos(angle)
                + view.screenHeight / 2).toFloat()
    }
}