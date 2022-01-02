package jp.kaleidot725.orbit.ui.page

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

data class CalculatorState(
    val total: Int = 0
)

sealed class CalculatorSideEffect {
    data class ADD(val text: String) : CalculatorSideEffect()
}

class CalculatorViewModel: ContainerHost<CalculatorState, CalculatorSideEffect>, ViewModel() {
    override val container = container<CalculatorState, CalculatorSideEffect>(CalculatorState())

    fun add(number: Int) = intent {
        postSideEffect(CalculatorSideEffect.ADD("Adding $number to ${state.total}!"))
        reduce {
            state.copy(total = state.total + number)
        }
    }
}