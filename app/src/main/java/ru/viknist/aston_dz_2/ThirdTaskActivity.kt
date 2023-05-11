package ru.viknist.aston_dz_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes

class ThirdTaskActivity : AppCompatActivity() {
    private val COUNT_KEY = "countKey"
    private var mCount: Int = 0
    private val mShowCount by bind<TextView>(R.id.show_count)
    private val buttonCount by bind<Button>(R.id.button_count)
    private val buttonToast by bind<Button>(R.id.button_toast)
    private val buttonZero by bind<Button>(R.id.button_zero)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_task)

        buttonCount.setOnClickListener {
            countUp()
        }

        buttonToast.setOnClickListener {
            showToast()
        }

        buttonZero.setOnClickListener {
            countToZero()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val restoredInt = savedInstanceState.getInt(COUNT_KEY)
        mShowCount.text = restoredInt.toString()
        mCount = restoredInt
        colorButtons(mCount)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT_KEY, mCount)
    }

    fun countUp() {
        mCount++
        mShowCount.text = mCount.toString()
        colorButtons(mCount)
    }

    fun showToast() {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    fun countToZero() {
        mCount = 0
        mShowCount.text = getString(R.string.count_initial_value)
        buttonZero.setBackgroundColor(getColor(R.color.grey))
    }

    fun <T : Any?> bind(@IdRes idRes: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<View>(idRes) as T }
    }

    fun colorButtons(count: Int) {
        if (count != 0) {
            buttonZero.setBackgroundColor(getColor(R.color.light_blue))
        }
        if (count % 2 == 0) {
            buttonCount.setBackgroundColor(getColor(R.color.teal_200))
        } else {
            buttonCount.setBackgroundColor(getColor(R.color.teal_700))
        }
    }
}