package castelles.com.github.iaraapp.ui

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import castelles.com.github.iaraapp.databinding.PlaceDetailsDialogBinding

class PlaceDetailsDialog: DialogFragment() {

    private lateinit var binding: PlaceDetailsDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = with (PlaceDetailsDialogBinding.inflate(inflater)) {
        binding = this
        root
    }
    override fun show(manager: FragmentManager, tag: String?) {
        super.show(manager, tag)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val params = WindowManager.LayoutParams().also {
            it.copyFrom(dialog?.window?.attributes)
            it.width = WindowManager.LayoutParams.MATCH_PARENT
            it.height = WindowManager.LayoutParams.WRAP_CONTENT

        }
        dialog?.window?.run {
            setGravity(Gravity.CENTER)
            val inset = InsetDrawable(ColorDrawable(Color.TRANSPARENT), 30)
            setBackgroundDrawable(inset)
            attributes = params
        }
    }



    companion object {
        const val TAG = "PlaceDetailsDialog"
    }

}