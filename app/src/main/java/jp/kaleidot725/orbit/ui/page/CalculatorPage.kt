package jp.kaleidot725.orbit.ui.page

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.flow.collect

@Composable
fun CalculatorPage(viewModel: CalculatorViewModel) {
    val context = LocalContext.current
    val state = viewModel.container.stateFlow.collectAsState().value

    LaunchedEffect(viewModel) {
        viewModel.container.sideEffectFlow.collect {
            when(it) {
                is CalculatorSideEffect.ADD -> {
                    Toast.makeText(context, "ADD", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.wrapContentSize()) {
            Text(text = "COUNT")
            Text(text = state.total.toString())
            Button(onClick = { viewModel.add(1) }) {
                Text(text = "ADD ONE")
            }
        }
    }
}

@Preview
@Composable
fun Preview_CalculatorPage() {
    CalculatorPage(viewModel = CalculatorViewModel())
}