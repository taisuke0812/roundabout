package research.lab.naganawa.roundabout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.next_activity.*

class next_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.next_activity)

        val judge = intent.getBooleanExtra("data",false)

        if(judge){
            text.setText("ラウンドアバウトですね")
        }else{
            text.setText("ラウンドアバウトではありません")
        }
    }
}
