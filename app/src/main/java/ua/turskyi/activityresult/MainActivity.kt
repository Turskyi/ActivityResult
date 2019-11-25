package ua.turskyi.activityresult

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

const val REQUEST_CODE_COLOR = 1
const val REQUEST_CODE_ALIGN = 2

class MainActivity :AppCompatActivity(), View.OnClickListener {
    private var tvText: TextView? = null
    private var btnColor: Button? = null
    private var btnAlign: Button? = null
    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvText = findViewById<View>(R.id.tvText) as TextView
        btnColor = findViewById<View>(R.id.btnColor) as Button
        btnAlign = findViewById<View>(R.id.btnAlign) as Button
        btnColor!!.setOnClickListener(this)
        btnAlign!!.setOnClickListener(this)
    }

   override fun onClick(v: View?) {
       val intent: Intent
       when (v!!.id) {
           R.id.btnColor -> {
               intent = Intent(this, ColorActivity::class.java)
               startActivityForResult(intent, REQUEST_CODE_COLOR)
           }
           R.id.btnAlign -> {
               intent = Intent(this, AlignActivity::class.java)
               startActivityForResult(intent, REQUEST_CODE_ALIGN)
           }
       }
    }

  override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
      super.onActivityResult(requestCode, resultCode, data)
      // show in Logs values of requestCode and resultCode
        Log.d("myLogs", "requestCode = $requestCode, resultCode = $resultCode")
        // if it was ОК
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_COLOR -> {
                    val color = data?.getIntExtra("color", Color.WHITE)
                    color?.let { tvText!!.setTextColor(it) }
                }
                REQUEST_CODE_ALIGN -> {
                    val align = data?.getIntExtra("alignment", Gravity.START)
                    if (align != null) {
                        tvText!!.gravity = align
                    }
                }
            }
            // if it was not ОК
        } else {
            Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show()
        }
    }
}
