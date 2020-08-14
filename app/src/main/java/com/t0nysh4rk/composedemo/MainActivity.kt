package com.t0nysh4rk.composedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxHeight
import androidx.ui.layout.padding
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.t0nysh4rk.composedemo.ui.ComposeDemoTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemo{
                MyScreenContent()
            }
            }
        }
    }

    @Composable
    fun ComposeDemo(content: @Composable() () -> Unit) {
        ComposeDemoTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}
    @Composable
    fun MyScreenContent(names: List<String> = listOf("Tony", "there")) {
    val counterState = state { 0 }

    Column(modifier = Modifier.fillMaxHeight()) {
        Column(modifier = Modifier.weight(1f)) {
            for (name in names) {
                Greeting(name = name)
                Divider(color = Color.Black)
            }
        }
        Counter(
                count = counterState.value,
                updateCount = { newCount ->
                    counterState.value = newCount
                }
        )
    }
}

    @Composable
    fun Greeting(name: String) {
        Surface(color = Color.White) {
            Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
        }
    }


    @Composable
    fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
            onClick = { updateCount(count + 1) },
            backgroundColor = if (count > 5) Color.Green else Color.White
    ) {
        Text("I've been clicked $count times")
    }
}

    @Preview("MyScreen preview")
    @Composable
    fun DefaultPreview() {
        ComposeDemoTheme {
            MyScreenContent()
    }
}