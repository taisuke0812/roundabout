package research.lab.naganawa.roundabout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.exp

class MainActivity : AppCompatActivity() {
    public val tf = 2.9
    public val s = 0.8
    public val tc = 4.1
    public val tau = 2.1
    public val branch = 4
    public var entry: Array<Double> = arrayOf(0.0,0.0,0.0,0.0)
    public var straight:Double=0.7
    public var right = 0.2
    public var left = 0.1
    public var judge_data:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            straight = edit_straight.text.toString().toDouble()
            right = edit_right.text.toString().toDouble()
            left = edit_left.text.toString().toDouble()
            entry[0] = entry1.text.toString().toDouble()
            entry[1] = entry2.text.toString().toDouble()
            entry[2] = entry3.text.toString().toDouble()
            entry[3] = entry4.text.toString().toDouble()

            judge_data = Calculate()

            val intent = Intent(applicationContext,next_activity::class.java)
            intent.putExtra("data",this.judge_data)
            startActivity(intent)
        }


    }


    fun Calculate():Boolean{
        var x0:Double
        var x1:Double
        var x2:Double
        var q_ci: Array<Double> = arrayOf(0.0,0.0,0.0,0.0)
        var ci: Array<Double> = arrayOf(0.0,0.0,0.0,0.0)
        var ans: Array<Double> = arrayOf(0.0,0.0,0.0,0.0)
        var i = 0
        var judge: Boolean = false

        for (data in entry){
            q_ci[i] = data * (this.straight + this.right)
            x0 = q_ci[i] / 3600
            x1 = 1 - (this.tau * x0)
            x2 = exp(-x0 * (this.tc - (this.tf / 2) - this.tau))
            ci[i] = this.s * (3600 / this.tf) * x1 * x2
            ans[i] = data / ci[i];
            i++
        }
        if((ans[0] < 0.8) and (ans[1] < 0.8) and (ans[2] < 0.8) and (ans[3] < 0.8)) {
            judge = true
        }
        return judge
    }
}
