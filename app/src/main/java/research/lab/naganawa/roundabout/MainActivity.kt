package research.lab.naganawa.roundabout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout.*
import kotlinx.android.synthetic.main.next_activity.view.*
import java.lang.Math.exp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        start_button.setOnClickListener {
            val start = Intent(this,CalcRA::class.java)
            startActivity(start)
        }

    }


}
