package ru.viknist.aston_dz_2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity

class SecondTaskActivity : AppCompatActivity() {
    private val COUNT_KEY = "countKey"
    private var mCount: Int = 0
    private val mShowCount by bind<TextView>(R.id.show_count)
    private val buttonCount by bind<Button>(R.id.button_count)
    private val buttonToast by bind<Button>(R.id.button_toast)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_task)

        buttonCount.setOnClickListener {
            countUp()
        }

        buttonToast.setOnClickListener {
            showToast()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mCount = savedInstanceState.getInt(COUNT_KEY)
        mShowCount.text = mCount.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT_KEY, mCount)
    }

    fun countUp() {
        mCount++
        mShowCount.text = mCount.toString()
    }

    fun showToast() {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    fun <T : Any?> bind(@IdRes idRes: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<View>(idRes) as T }
    }
}