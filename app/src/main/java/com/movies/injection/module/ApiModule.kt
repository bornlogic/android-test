package com.movies.injection.module

import com.movies.di.MovieApi
import com.movies.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {

    private val BASE_URL = "https://api.themoviedb.org/3/"

    @Provides
    fun provideFilmesApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    fun providerCountriesServices() : MovieRepository {
        return MovieRepository()
    }
}