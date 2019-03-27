package com.example.cloth_io.others

import android.content.Context
import android.util.DisplayMetrics

class Extension {
    companion object {
        fun dpToPx(dp: Int, context: Context) : Int {
            val displayMetrics = context.resources.displayMetrics
            return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
        }
    }
}