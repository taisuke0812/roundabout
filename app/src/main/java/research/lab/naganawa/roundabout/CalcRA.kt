package research.lab.naganawa.roundabout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class CalcRA:AppCompatActivity(){
    public val tf = 2.9
    public val s = 0.8
    public val tc = 4.1
    public val tau = 2.1
    public val branch = 4
    public var entry: Array<Double> = arrayOf(0.0)
    public var straight = 0.7
    public var right = 0.2
    public var left = 0.1
    public var judge_data:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            straight = Istraight.text.toString().toDouble()
            right = Iright.text.toString().toDouble()
            left = Ileft.text.toString().toDouble()
            entry[0] = input1.text.toString().toDouble()
            //entry[1] = input2.text.toString().toDouble()
            //entry[2] = input3.text.toString().toDouble()
            //entry[3] = input4.text.toString().toDouble()

            judge_data = Calculate()
            val fragment = ResultFragment.newInstance(judge_data)
            supportFragmentManager.beginTransaction().add(R.id.layout_view,fragment).commit()
            //val intent = Intent(applicationContext,next_activity::class.java)
            //intent.putExtra("data",this.judge_data)
            //startActivity(intent)
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
            x2 = Math.exp(-x0 * (this.tc - (this.tf / 2) - this.tau))
            ci[i] = this.s * (3600 / this.tf) * x1 * x2
            ans[i] = data / ci[i];
            i++
        }
        //if((ans[0] < 0.8) and (ans[1] < 0.8) and (ans[2] < 0.8) and (ans[3] < 0.8)) {
        if(ans[0] < 0.8){
            judge = true
        }
        return judge
    }
}