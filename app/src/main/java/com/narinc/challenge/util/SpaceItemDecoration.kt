package com.narinc.challenge.util

import android.graphics.Rect
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpaceItemDecoration private constructor(
    private val start: Int = DEFAULT_SPACE,
    private val top: Int = DEFAULT_SPACE,
    private val end: Int = DEFAULT_SPACE,
    private val bottom: Int = DEFAULT_SPACE
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = start
        outRect.top = top
        outRect.right = end
        outRect.bottom = bottom
    }

    companion object {
        private const val DEFAULT_SPACE: Int = 4
        private const val complexUnitDip = TypedValue.COMPLEX_UNIT_DIP

        fun create(metrics: DisplayMetrics, space: Int = DEFAULT_SPACE): SpaceItemDecoration {
            val spaceAsDP = TypedValue.applyDimension(complexUnitDip, space.toFloat(), metrics).toInt()
            return create(metrics, spaceAsDP, spaceAsDP, spaceAsDP, spaceAsDP)
        }

        fun create(metrics: DisplayMetrics, vertical: Int, horizontal: Int): SpaceItemDecoration {
            val verticalAsDP = TypedValue.applyDimension(complexUnitDip, vertical.toFloat(), metrics).toInt()
            val horizontalAsDP = TypedValue.applyDimension(complexUnitDip, horizontal.toFloat(), metrics).toInt()
            return create(metrics, horizontalAsDP, verticalAsDP, horizontalAsDP, verticalAsDP)
        }

        fun create(metrics: DisplayMetrics, start: Int, top: Int, end: Int, bottom: Int): SpaceItemDecoration {
            val startAsDP = TypedValue.applyDimension(complexUnitDip, start.toFloat(), metrics).toInt()
            val topAsDP = TypedValue.applyDimension(complexUnitDip, top.toFloat(), metrics).toInt()
            val endAsDP = TypedValue.applyDimension(complexUnitDip, end.toFloat(), metrics).toInt()
            val bottomAsDP = TypedValue.applyDimension(complexUnitDip, bottom.toFloat(), metrics).toInt()
            return SpaceItemDecoration(startAsDP, topAsDP, endAsDP, bottomAsDP)
        }
    }
}
