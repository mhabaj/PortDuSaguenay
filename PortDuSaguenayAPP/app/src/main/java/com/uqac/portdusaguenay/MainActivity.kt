package com.uqac.portdusaguenay

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

private const val MIN_STEMS = 2
private const val MAX_STEMS = 20

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    StemMixerScreen()
                }
            }
        }
    }
}

@Composable
private fun StemMixerScreen() {
    val stems = remember { mutableStateListOf(*defaultStems().toTypedArray()) }
    var isPlaying by remember { mutableStateOf(false) }

    val context = LocalContext.current

    val players = remember(stems.size) {
        stems.map {
            ExoPlayer.Builder(context).build().apply {
                setMediaItem(MediaItem.fromUri(it.uri))
                prepare()
                volume = it.volume
            }
        }
    }

    DisposableEffect(players) {
        onDispose {
            players.forEach { it.release() }
        }
    }

    LaunchedEffect(isPlaying, players) {
        players.forEach { player ->
            if (isPlaying) player.play() else player.pause()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Stem Player (2 à 20 pistes)",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {
                if (stems.size < MAX_STEMS) stems.add(nextStem(stems.size + 1))
            }) {
                Text("+ Stem")
            }
            OutlinedButton(onClick = {
                if (stems.size > MIN_STEMS) stems.removeLast()
            }) {
                Text("- Stem")
            }
            OutlinedButton(onClick = { isPlaying = !isPlaying }) {
                Text(if (isPlaying) "Pause" else "Play")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text("Nombre de stems: ${stems.size}")

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(stems) { index, stem ->
                StemVolumeRow(
                    index = index,
                    stem = stem,
                    onVolumeChange = { value ->
                        stems[index] = stem.copy(volume = value)
                        if (index < players.size) {
                            players[index].volume = value
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun StemVolumeRow(index: Int, stem: Stem, onVolumeChange: (Float) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Stem ${index + 1}: ${stem.name}")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Slider(
                value = stem.volume,
                onValueChange = onVolumeChange,
                valueRange = 0f..1f,
                modifier = Modifier.weight(1f)
            )
            Text(" ${(stem.volume * 100).toInt()}%")
        }
    }
}

data class Stem(
    val name: String,
    val uri: Uri,
    val volume: Float = 1f
)

private fun defaultStems(): List<Stem> = listOf(
    Stem(name = "Drums", uri = Uri.parse("asset:///stems/drums.mp3")),
    Stem(name = "Bass", uri = Uri.parse("asset:///stems/bass.mp3"))
)

private fun nextStem(index: Int): Stem = Stem(
    name = "Stem $index",
    uri = Uri.parse("asset:///stems/stem_${index}.mp3")
)

