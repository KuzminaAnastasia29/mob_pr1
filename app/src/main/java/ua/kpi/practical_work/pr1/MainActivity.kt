package ua.kpi.practical_work.pr1
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import ua.kpi.practical_work.pr1.composables.AuthScreen
import ua.kpi.practical_work.pr1.composables.SmartGridApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var isLoggedIn by remember { mutableStateOf(false) }

                    if (isLoggedIn) {
                        SmartGridApp()
                    } else {
                        AuthScreen(onAuthSuccess = { isLoggedIn = true })
                    }
                }
            }
        }
    }
}