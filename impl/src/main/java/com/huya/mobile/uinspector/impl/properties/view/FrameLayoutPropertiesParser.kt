package com.huya.mobile.uinspector.impl.properties.view

import android.widget.FrameLayout
import com.yy.mobile.whisper.Output

/**
 * @author YvesCheung
 * 2021/1/4
 */
open class FrameLayoutPropertiesParser(view: FrameLayout) : ViewPropertiesParser<FrameLayout>(view) {

    override fun parse(@Output props: MutableMap<String, Any?>) {
        super.parse(props)

        if (view.measureAllChildren) {
            props["measureAllChildren"] = view.measureAllChildren
        }
    }
}