package research.lab.naganawa.roundabout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Input1 : AppCompatActivity() {

    public var straight:Double=0.7
    public var right = 0.2
    public var left = 0.1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input1)
    }
}
