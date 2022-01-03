package jp.kaleidot725.orbit.di

import jp.kaleidot725.orbit.ui.page.CounterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        CounterViewModel()
    }
}