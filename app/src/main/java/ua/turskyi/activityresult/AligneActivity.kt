package ua.turskyi.activityresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button


class AlignActivity : Activity(), View.OnClickListener {
    private var btnLeft: Button? = null
    private var btnCenter: Button? = null
    private var btnRight: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_align)
        btnLeft = findViewById<View>(R.id.btnLeft) as Button
        btnCenter = findViewById<View>(R.id.btnCenter) as Button
        btnRight = findViewById<View>(R.id.btnRight) as Button
        btnLeft!!.setOnClickListener(this)
        btnCenter!!.setOnClickListener(this)
        btnRight!!.setOnClickListener(this)
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