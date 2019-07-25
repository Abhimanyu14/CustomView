package com.appz.abhi.customview.customview

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.appz.abhi.customview.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.my_image_view.view.*

class MyImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : CardView(context, attrs, defStyle) {


    private lateinit var drawable: Drawable
    private var localContext: Context
    private var localAttrs: AttributeSet?

    init {
1
        LayoutInflater.from(context).inflate(R.layout.my_image_view, this, true)

        // Card layout radius
        radius = 32.0.toFloat()


        localContext = context
        localAttrs = attrs

        updateView(localContext, localAttrs)
    }

    private fun updateView(context: Context, attrs: AttributeSet?) {

        attrs.let {

            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.MyImageView, 0, 0
            )

            val title = resources.getText(
                typedArray.getResourceId(
                    R.styleable.MyImageView_my_image_view_title,
                    R.string.image_view_default_title
                )
            )
            my_image_view_title.text = title

            Log.e("My Image View", "Title set")

            drawable = resources.getDrawable(
                typedArray.getResourceId(
                    R.styleable.MyImageView_my_image_view_src,
                    R.drawable.women
                )
            )
            Glide.with(my_image_view_image_view.context).load(drawable)
                .into(my_image_view_image_view)

            Log.e("My Image View", "Image set")

            typedArray.recycle()
        }
    }

    /*
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        // Get image view width
        val width = MeasureSpec.getSize(widthMeasureSpec)
        var height = MeasureSpec.getSize(heightMeasureSpec)
        Log.e("My Image View", "On measure : image view width: $width")
        Log.e("My Image View", "On measure : image view height: $height")

        val drawableWidth = drawable.intrinsicWidth
        val drawableHeight = drawable.intrinsicHeight
        val aspectRatio = drawableWidth.toFloat() / drawableHeight

        Log.e("My Image View", "On measure : drawable width: $drawableWidth")
        Log.e("My Image View", "On measure : drawable height: $drawableHeight")
        Log.e("My Image View", "On measure : aspect ratio : $aspectRatio")

        height = (width / aspectRatio).toInt()
        Log.e("My Image View", "On measure : image view new width: $width")
        Log.e("My Image View", "On measure : image view new height: $height")

        setMeasuredDimension(width, height)

        Log.e("My Image View", "On measure : Updating view")
        updateView(localContext, localAttrs)
    }
    */
}
