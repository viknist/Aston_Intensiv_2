package ru.viknist.aston_dz_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.IdRes

class MainActivity : AppCompatActivity() {

    private val firstTaskButton by bind<Button>(R.id.firstTaskButton)
    private val secondTaskButton by bind<Button>(R.id.secondTaskButton)
    private val thirdTaskButton by bind<Button>(R.id.thirdTaskButton)
    private val fourthTaskButton by bind<Button>(R.id.fourthTaskButton)
    private val fifthTaskButton by bind<Button>(R.id.fifthTaskButton)
    private val sixthTaskButton by bind<Button>(R.id.sixthTaskButton)
    private val seventhTaskButton by bind<Button>(R.id.seventhTaskButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstTaskButton.setOnClickListener {
            openTaskActivity(1)
        }
        secondTaskButton.setOnClickListener {
            openTaskActivity(2)
        }
        thirdTaskButton.setOnClickListener {
            openTaskActivity(3)
        }
        fourthTaskButton.setOnClickListener {
            openTaskActivity(4)
        }
        fifthTaskButton.setOnClickListener {
            openTaskActivity(5)
        }
        sixthTaskButton.setOnClickListener {
            openTaskActivity(6)
        }
        seventhTaskButton.setOnClickListener {
            openTaskActivity(7)
        }

    }

    fun <T : Any?> bind(@IdRes idRes: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<View>(idRes) as T }
    }

    fun openTaskActivity(taskNum: Int){
        val intent = Intent(this, when(taskNum){
            1 -> FirstTaskActivity::class.java
            2 -> SecondTaskActivity::class.java
            3 -> ThirdTaskActivity::class.java
            4 -> FourthTaskActivity::class.java
            5 -> FifthTaskActivity::class.java
            6 -> SixthTaskActivity::class.java
            7 -> SeventhTaskActivity::class.java
            else -> null
        })
        startActivity(intent)
    }
}