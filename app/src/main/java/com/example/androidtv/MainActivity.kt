package com.example.androidtv

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class MainActivity : ComponentActivity() {

    private var playerView: PlayerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        this.playerView = findViewById(R.id.player_view)
        val player = ExoPlayer.Builder(this).build()

        playerView!!.player = player
        val uri =
            Uri.parse("https://ts2.tarafdari.com/contents/user6984/content-sound/20_-_numb.mp3")
        var mediaItem = MediaItem.fromUri(uri)
        player.setMediaItem(mediaItem)

        player.prepare()
    }
}