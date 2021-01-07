package com.huya.mobile.uinspector.impl.properties.view

import android.graphics.Rect
import android.os.Build
import android.view.View
import com.huya.mobile.uinspector.util.*
import com.yy.mobile.whisper.Output

/**
 * Extract all properties we concerned from [view]
 *
 * @author YvesCheung
 * 2020/12/31
 */
open class ViewPropertiesParser<T : View>(protected val view: T) {

    open fun parse(@Output props: MutableMap<String, Any?>) {
        //todo: Should I just analyze the @InspectableProperty annotation by reflection?
        props["class"] = view::class.java.simpleName

        props["id"] =
            if (view.id <= 0) "NO_ID"
            else idToString(view.context, view.id)

        props["rect"] = Rect(view.left, view.top, view.right, view.bottom)

        if (view.visibility != View.VISIBLE) {
            props["visibility"] = visibilityToString(view.visibility)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val drawable = view.foreground
            if (drawable != null) {
                props["foreground"] = drawableToString(drawable)
            }

            val tint = view.foregroundTintList
            if (tint != null) {
                props["foregroundTint"] = view.foregroundTintList
            }
        }

        if (view.background != null) {
            props["background"] = drawableToString(view.background)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val tint = view.backgroundTintList
            if (tint != null) {
                props["backgroundTint"] = colorToString(tint)
            }

            if (view.backgroundTintMode != null) {
                props["backgroundTintMode"] = view.backgroundTintMode
            }
        }

        if (view.scrollX != 0) {
            props["scrollX"] = view.scrollX
        }

        if (view.scrollY != 0) {
            props["scrollY"] = view.scrollY
        }

        if (view.translationX != 0f) {
            props["translationX"] = view.translationX
        }

        if (view.translationY != 0f) {
            props["translationY"] = view.translationY
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            if (view.translationZ != 0f) {
                props["translationZ"] = view.translationZ
            }

            if (view.elevation != 0f) {
                props["elevation"] = view.elevation.dpStr
            }
        }

        if (view.scaleX != 1f) {
            props["scaleX"] = view.scaleX
        }

        if (view.scaleY != 1f) {
            props["scaleY"] = view.scaleY
        }

        if (view.rotation != 0f) {
            props["rotation"] = view.rotation
        }

        if (view.rotationX != 0f) {
            props["rotationX"] = view.rotationX
        }

        if (view.rotationY != 0f) {
            props["rotationY"] = view.rotationY
        }

        if (view.isSelected) {
            props["isSelected"] = view.isSelected
        }

        if (view.isFocusable) {
            props["isFocusable"] = view.isFocusable
        }

        if (view.isFocused) {
            props["isFocused"] = view.isFocused
        }

        if (view.isClickable) {
            props["isClickable"] = view.isClickable
        }

        if (view.isLongClickable) {
            props["isLongClickable"] = view.isLongClickable
        }

        if (view.contentDescription != null) {
            props["contentDescription"] = view.contentDescription
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            if (view.accessibilityPaneTitle != null) {
                props["accessibilityPaneTitle"] = view.accessibilityPaneTitle
            }
        }

        if (view.keepScreenOn) {
            props["keepScreenOn"] = view.keepScreenOn
        }

        if (view.pivotX != 0f) {
            props["pivotX"] = view.pivotX.dpStr
        }

        if (view.pivotY != 0f) {
            props["pivotY"] = view.pivotY.dpStr
        }
    }
}