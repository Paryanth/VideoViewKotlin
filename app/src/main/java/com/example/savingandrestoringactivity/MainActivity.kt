package com.example.savingandrestoringactivity

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var myVideoView: VideoView
    private var mediaController: MediaController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myVideoView = findViewById(R.id.videoview)
        configureVideoView()
    }

    private fun configureVideoView() {
        myVideoView.setVideoURI(Uri.parse("android.resource://"+packageName+"/"+R.raw.video))
        mediaController = MediaController(this)
        mediaController?.setAnchorView(myVideoView)
        myVideoView.setMediaController(mediaController)
        myVideoView.start()
    }
}