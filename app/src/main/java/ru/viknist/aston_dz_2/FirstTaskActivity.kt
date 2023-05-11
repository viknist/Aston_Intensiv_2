package ru.viknist.aston_dz_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class FirstTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_task)
        displayAllLogs()
    }

    fun displayAllLogs(){
        try{
            var number = 4 / 0
        } catch (exception :Exception) {
            Log.e("Main Activity", "ERROR ${exception.message}", exception)

        }

        Log.d("Main Activity", "DEBUG")
        Log.i("Main Activity", "INFO")
        Log.v("Main Activity", "VERBOSE")
        Log.w("Main Activity", "WARN")
        Log.wtf("Main ACTIVITY", "WTF")
    }
}