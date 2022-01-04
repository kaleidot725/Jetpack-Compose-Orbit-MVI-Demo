package jp.kaleidot725.orbit.ui.page

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collect

@Composable
fun CounterPage(viewModel: CounterViewModel) {
    val context = LocalContext.current
    val state = viewModel.container.stateFlow.collectAsState().value

    LaunchedEffect(viewModel) {
        viewModel.container.sideEffectFlow.collect {
            when (it) {
                is CounterSideEffect.Toast -> {
                    Toast.makeText(context, it.text, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Box {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .align(Alignment.Center)
            ) {
                Text(
                    text = state.total.toString(),
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Column(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Button(onClick = { viewModel.increment() }, modifier = Modifier.width(200.dp)) {
                        Text(text = "INCREMENT")
                    }
                    Button(onClick = { viewModel.decrement() }, modifier = Modifier.width(200.dp)) {
                        Text(text = "DECREMENT")
                    }
                    Button(onClick = { viewModel.reset() }, modifier = Modifier.width(200.dp)) {
                        Text(text = "RESET")
                    }
                }
            }
        }
    }
}