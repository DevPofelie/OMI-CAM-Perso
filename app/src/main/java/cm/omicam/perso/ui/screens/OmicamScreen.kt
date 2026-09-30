package cm.omicam.perso.ui.screens

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun OmicamScreen(title: String) {

    AndroidView(modifier = Modifier.fillMaxSize(),
        factory = { context -> WebView(context).apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
                WebViewClient()
                loadUrl("https://omicameroun.org/")
            }
        }
    )
}