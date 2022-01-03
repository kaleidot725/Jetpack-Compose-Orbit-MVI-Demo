package jp.kaleidot725.orbit.ui.page

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

data class CounterState(
    val total: Int = 0
)

sealed class CounterSideEffect {
    data class Toast(val text: String) : CounterSideEffect()
}

class CounterViewModel: ContainerHost<CounterState, CounterSideEffect>, ViewModel() {
    override val container = container<CounterState, CounterSideEffect>(CounterState())

    fun increment() = intent {
        postSideEffect(CounterSideEffect.Toast("Increment"))
        reduce {
            state.copy(total = state.total + 1)
        }
    }

    fun decrement() = intent {
        postSideEffect(CounterSideEffect.Toast("Decrement"))
        reduce {
            state.copy(total = state.total - 1)
        }
    }

    fun reset() = intent {
        postSideEffect(CounterSideEffect.Toast("Reset"))
        reduce {
            state.copy(total = 0)
        }
    }
}