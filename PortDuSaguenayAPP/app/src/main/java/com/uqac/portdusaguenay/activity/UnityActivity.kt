package com.uqac.portdusaguenay.activity

/*import com.unity3d.player.UnityPlayer*/

import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.core.content.ContextCompat.startActivity
import com.uqac.portdusaguenay.MainActivity

import com.unity3d.player.UnityPlayerActivity


class UnityActivity : UnityPlayerActivity() {
    // Setup activity layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addControlsToUnityFrame()
        val intent = intent
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
        setIntent(intent)
    }

    fun handleIntent(intent: Intent?) {
        if (intent == null || intent.extras == null) return
        if (intent.extras!!.containsKey("doQuit")) if (mUnityPlayer != null) {
            finish()
        }
    }

    protected fun showMainActivity(setToColor: String?) {
        val intent: Intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_SINGLE_TOP
        intent.putExtra("setColor", setToColor)
        startActivity(intent)
    }

    override fun onUnityPlayerUnloaded() {
        showMainActivity("")
    }

    fun addControlsToUnityFrame() {
        val layout: FrameLayout = mUnityPlayer

        run {
            val myButton = Button(this)
            myButton.text = "Retour à la carte"
            myButton.x = 800f
            myButton.y = 1800f
            myButton.setOnClickListener { this.finish()
                startActivity(Intent(this,DisplayCoursesMap::class.java))
            }
            layout.addView(myButton, 300, 200)
        }
    }
}