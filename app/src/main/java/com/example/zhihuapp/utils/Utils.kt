package com.example.zhihuapp.utils

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream

object Utils {

    /**
     * 将Bitmap的字节流压缩为目标大小
     * @targetSize  单位为Byte
     */
    fun getBytesFromCompressBitmap(
        bitmap: Bitmap,
        targetSize: Int
    ): ByteArray {
        val baos = ByteArrayOutputStream()
        var quality = 100
        bitmap.compress(Bitmap.CompressFormat.PNG, quality, baos)
        var bytes = baos.toByteArray()
        while (bytes.size > targetSize && quality >= 5) {
            quality -= 5
            if (quality < 0) {
                quality = 0
            }
            // 重置，不然会累加
            baos.reset()
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos)
            bytes = baos.toByteArray()
        }
        try {
            baos.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bytes
    }

}