package com.movies.injection.component

import com.movies.injection.module.ApiModule
import com.movies.repository.MovieRepository
import com.movies.ui.movie.MovieViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(repository: MovieRepository)

    fun inject(viewModel: MovieViewModel)
}