package research.lab.naganawa.roundabout

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.next_activity.*

class ResultFragment() : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = AlertDialog.Builder(context)
        return dialog.create()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.next_activity, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val key = arguments?.get("key")

        if(key ==false){
            image.setImageResource(R.drawable.failed)
        }else{
            image.setImageResource(R.drawable.success)
        }

        image.setOnClickListener {
            val intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        val TAG: String = ResultFragment::class.java.simpleName
        fun newInstance(key: Boolean): Fragment {
            val instance = ResultFragment()
            val args = Bundle()
            args.putBoolean("key", key)
            instance.arguments = args
            return instance
        }
    }
}