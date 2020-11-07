package ua.turskyi.activityresult

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_align.*

class AlignActivity : AppCompatActivity(R.layout.activity_align), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnLeft.setOnClickListener(this)
        btnCenter.setOnClickListener(this)
        btnRight.setOnClickListener(this)
    }

   override fun onClick(v: View) {
        val intent = Intent()
        when (v.id) {
            R.id.btnLeft -> intent.putExtra("alignment", Gravity.START)
            R.id.btnCenter -> intent.putExtra("alignment", Gravity.CENTER)
            R.id.btnRight -> intent.putExtra("alignment", Gravity.END)
        }
        setResult(RESULT_OK, intent)
        finish()
    }
}