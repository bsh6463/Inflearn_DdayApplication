package com.example.ddayapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val startBtn = findViewById<Button>(R.id.startBtn)
        val endBtn = findViewById<Button>(R.id.endBtn)

        var startDate = ""
        var endDate = ""

        var calendar_start = Calendar.getInstance()
        var calendar_end = Calendar.getInstance()

        startBtn.setOnClickListener {

            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    startDate = "${year}${month+1}${dayOfMonth}"
                    Log.d("day", startDate)

                    calendar_start.set(year, month+1, dayOfMonth)

                }

            }, year, month, day)
            dlg.show()
        }

        endBtn.setOnClickListener {

            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    endDate = "${year}${month+1}${dayOfMonth}"
                    Log.d("day", endDate)
                    calendar_end.set(year, month+1, dayOfMonth)

                    val finalDays = TimeUnit.MILLISECONDS.toDays(calendar_end.timeInMillis - calendar_start.timeInMillis)

                    findViewById<TextView>(R.id.finalDate).setText(finalDays.toString())
                }

            }, year, month, day)
            dlg.show()

        }
    }
}