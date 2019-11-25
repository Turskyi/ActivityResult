package ua.turskyi.activityresult

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button

class ColorActivity : Activity(), View.OnClickListener {
    var btnRed: Button? = null
    var btnGreen: Button? = null
    var btnBlue: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)
        btnRed = findViewById<View>(R.id.btnRed) as Button
        btnGreen = findViewById<View>(R.id.btnGreen) as Button
        btnBlue = findViewById<View>(R.id.btnBlue) as Button
        btnRed!!.setOnClickListener(this)
        btnGreen!!.setOnClickListener(this)
        btnBlue!!.setOnClickListener(this)
    }

   override fun onClick(v: View) {
        val intent = Intent()
        when (v.id) {
            R.id.btnRed -> intent.putExtra("color", Color.RED)
            R.id.btnGreen -> intent.putExtra("color", Color.GREEN)
            R.id.btnBlue -> intent.putExtra("color", Color.BLUE)
        }
        setResult(RESULT_OK, intent)
        finish()
    }
}