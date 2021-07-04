package ua.turskyi.activityresult

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

const val REQUEST_CODE_COLOR = 1
const val REQUEST_CODE_ALIGN = 2
class MainActivity :AppCompatActivity(R.layout.activity_main), View.OnClickListener {

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        super.onCreate(savedInstanceState)
        btnColor.setOnClickListener(this)
        btnAlign.setOnClickListener(this)
    }

   override fun onClick(v: View?) {
       val intent: Intent
       when (v?.id) {
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
                    color?.let { tvText.setTextColor(it) }
                }
                REQUEST_CODE_ALIGN -> {
                    val align = data?.getIntExtra("alignment", Gravity.START)
                    align?.let{ tvText.gravity = it}
                }
            }
            /* if it was not ОК */
        } else {
            Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show()
        }
    }
}


