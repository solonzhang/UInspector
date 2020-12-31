package com.huya.mobile.uinspector.ui.panel

import android.app.Activity
import android.app.Dialog
import android.app.DialogFragment
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import com.huya.mobile.uinspector.ui.UInspectorMask


/**
 * @author YvesCheung
 * 2020/12/30
 */
internal class UInspectorLegacyDialogFragment : DialogFragment(), UInspectorPanel {

    override fun show(activity: Activity) {
        show(activity.fragmentManager, "UInspectorLegacyDialogFragment")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(STYLE_NO_FRAME, 0)
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.setDimAmount(0f)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return UInspectorMask(inflater.context)
    }

    override fun onStart() {
        super.onStart()
        val rootView = activity?.findViewById<View>(android.R.id.content)
        if (rootView != null) {
            dialog?.window?.setLayout(rootView.width, rootView.height)
        } else {
            dialog?.window?.setLayout(MATCH_PARENT, MATCH_PARENT)
        }
    }

    override fun close() {
        try {
            dismissAllowingStateLoss()
        } catch (ignore: Throwable) {
        }
    }
}