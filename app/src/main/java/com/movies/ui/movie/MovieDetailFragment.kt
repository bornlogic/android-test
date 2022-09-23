package com.movies.ui.movie


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.movies.R
import com.movies.databinding.FragmentMovieDetailBinding
import com.movies.model.Movie

class MovieDetailFragment : Fragment() {

    private lateinit var dataBinding: FragmentMovieDetailBinding
    lateinit var movie : Movie

    companion object {
        val TAG: String = MovieDetailFragment::class.java.simpleName
        private val MOVIE = "movie"

        fun newInstance(movie: Movie): MovieDetailFragment {
            val args = Bundle()
            args.putSerializable(MOVIE, movie)
            val fragment = MovieDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false)
        dataBinding = FragmentMovieDetailBinding.bind(rootView)

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            this.movie = it.getSerializable(MOVIE) as Movie
            dataBinding.movie = movie
        }
    }

}
