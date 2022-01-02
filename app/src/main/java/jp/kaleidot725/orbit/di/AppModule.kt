package jp.kaleidot725.orbit.di

import jp.kaleidot725.orbit.ui.page.CalculatorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        CalculatorViewModel()
    }
}