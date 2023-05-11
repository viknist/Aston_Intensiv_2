package ru.viknist.aston_dz_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes

class FifthTaskActivity : AppCompatActivity() {
    private val COUNT_KEY = "countKey"
    private var mCount: Int = 0
    private val mShowCount by bind<TextView>(R.id.show_count)
    private val buttonCount by bind<Button>(R.id.button_count)
    private val buttonHello by bind<Button>(R.id.button_hello)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth_task)

        buttonCount.setOnClickListener {
            countUp()
        }

        buttonHello.setOnClickListener {
            showHello()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val restoredInt = savedInstanceState.getInt(COUNT_KEY)
        mShowCount.text = restoredInt.toString()
        mCount = restoredInt
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT_KEY, mCount)
    }

    fun countUp() {
        mCount++
        mShowCount.text = mCount.toString()
    }

    fun showHello() {
        val intent = Intent(this, HelloActivity::class.java)
        intent.putExtra("Count", mCount)
        startActivity(intent)
    }

    fun <T : Any?> bind(@IdRes idRes: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<View>(idRes) as T }
    }
}