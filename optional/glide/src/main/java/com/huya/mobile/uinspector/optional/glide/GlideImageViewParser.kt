package com.huya.mobile.uinspector.optional.glide

import android.widget.ImageView
import com.bumptech.glide.request.Request
import com.huya.mobile.uinspector.impl.properties.view.ImageViewPropertiesParser

/**
 * @author YvesCheung
 * 2021/1/7
 */
class GlideImageViewParser(view: ImageView, private val request: Request) :
    ImageViewPropertiesParser(view) {

    override fun parse(props: MutableMap<String, Any?>) {
        super.parse(props)
        GlideRequestParser(view.context, request).parse(props)
    }
}