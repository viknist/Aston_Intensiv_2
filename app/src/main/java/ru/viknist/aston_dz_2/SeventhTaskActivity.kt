package ru.viknist.aston_dz_2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat

class SeventhTaskActivity : AppCompatActivity() {

    private val websiteEditText by bind<EditText>(R.id.website_edittext)
    private val openWebsiteButton by bind<Button>(R.id.open_website_button)
    private val locationEditText by bind<EditText>(R.id.location_edittext)
    private val openLocationButton by bind<Button>(R.id.open_location_button)
    private val shareEditText by bind<EditText>(R.id.share_edittext)
    private val shareTextButton by bind<Button>(R.id.share_text_button)
    private val openCameraButton by bind<Button>(R.id.openCameraButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seventh_task)

        openWebsiteButton.setOnClickListener {
            val webpage = Uri.parse(websiteEditText.text.toString())
            intent = Intent(Intent.ACTION_VIEW, webpage)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent);
            } else {
                Log.d("ImplicitIntents", "Can't handle this intent!");
            }
        }

        openLocationButton.setOnClickListener {
            val loc = locationEditText.text.toString()
            val addressUri = Uri.parse("geo:0,0?q=$loc")
            val intent = Intent(Intent.ACTION_VIEW, addressUri)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Log.d("ImplicitIntents", "Can't handle this intent!")
            }
        }

        shareTextButton.setOnClickListener {
            val text = shareEditText.text.toString()
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder(this)
                .setType(mimeType)
                .setChooserTitle(getString(R.string.share_text))
                .setText(text)
                .startChooser()
        }

        openCameraButton.setOnClickListener {
            val intent = Intent("android.media.action.IMAGE_CAPTURE")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Log.d("ImplicitIntents", "Can't handle this intent!")
            }
        }
    }

    fun <T : Any?> bind(@IdRes idRes: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<View>(idRes) as T }
    }
}