package ru.viknist.aston_dz_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.IdRes

class SixthTaskActivity : AppCompatActivity() {

    private val COUNT_KEY = "countKey"
    private var mCount: Int = 0
    private val mShowCount by bind<TextView>(R.id.countText)
    private val addOneCountButton by bind<Button>(R.id.addOneCountButton)
    private val editText by bind<EditText>(R.id.editText)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixth_task)
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt(COUNT_KEY)
            mShowCount.text = mCount.toString()
        }

        addOneCountButton.setOnClickListener {
            countUp()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT_KEY, mCount)
    }

    fun countUp() {
        mCount++
        mShowCount.text = mCount.toString()
    }

    fun <T : Any?> bind(@IdRes idRes: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<View>(idRes) as T }
    }
}