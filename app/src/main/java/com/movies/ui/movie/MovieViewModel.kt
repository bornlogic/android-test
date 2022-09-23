package com.movies.ui.movie

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.movies.injection.component.DaggerApiComponent
import com.movies.model.Movie
import com.movies.model.MovieResult
import com.movies.repository.MovieRepository

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieViewModel : ViewModel() {

    @Inject
    lateinit var moviewRepository: MovieRepository

    private val disposable = CompositeDisposable()

    val movies = MutableLiveData<List<Movie>>()
    val showProgress = MutableLiveData<Int>()
    val showErrorMessage = MutableLiveData<Int>()
    val errorMessage = MutableLiveData<String>()

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getAllMovies(page: Int) {
        fetchMovies(page)
    }

    private fun fetchMovies(page: Int) {
        showProgress.value = View.VISIBLE
        showErrorMessage.value = View.GONE
        errorMessage.value = ""

        disposable.add(
            moviewRepository.getAllMovies(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<MovieResult>(){
                    override fun onSuccess(value: MovieResult) {
                        showProgress.value = View.GONE
                        value.results?.apply {
                            movies.value = this
                        }
                    }

                    override fun onError(e: Throwable) {
                        showErrorMessage.value = View.VISIBLE
                        errorMessage.value = e.message
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}