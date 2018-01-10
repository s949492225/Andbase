package com.syiyi.base.image

import android.graphics.*
import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.syiyi.base.ContextHolder
import java.security.MessageDigest

/**
 * 加载图片的类
 * Created by songlintao on 2018/1/10.
 */
@Suppress("unused")
object ImageLoader {

    fun <T> load(data:T, @DrawableRes placeHolderId: Int = -1, radius: Float = 0F, isFitCenter: Boolean = false, imageView: ImageView) {
        with(GlideApp.with(ContextHolder.context).load(data), {
            if (placeHolderId != -1)
                placeholder(placeHolderId)
            if (radius != 0F)
                transform(RoundCornerTransform(radius))
            if (isFitCenter)
                fitCenter()
            into(imageView)
        })
    }

    fun clear(imageView: ImageView) {
        GlideApp.with(ContextHolder.context).clear(imageView)
    }

    class RoundCornerTransform(private val radius: Float = 0F) : BitmapTransformation() {

        override fun transform(pool: BitmapPool, source: Bitmap, outWidth: Int, outHeight: Int): Bitmap? {

            var result: Bitmap? = pool.get(source.width, source.height, Bitmap.Config.ARGB_8888)
            if (result == null) {
                result = Bitmap.createBitmap(source.width, source.height, Bitmap.Config.ARGB_8888)
            }
            val canvas = Canvas(result!!)
            val paint = Paint()
            paint.shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
            paint.isAntiAlias = true
            val rectF = RectF(0f, 0f, source.width.toFloat(), source.height.toFloat())
            canvas.drawRoundRect(rectF, source.width * radius, source.height * radius, paint)
            return result
        }

        override fun updateDiskCacheKey(messageDigest: MessageDigest) {
            messageDigest.update("roundcorner".toByteArray())
        }
    }

}