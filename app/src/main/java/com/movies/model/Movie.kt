package com.movies.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Movie (
    @Expose
    var adult: Boolean? = null,
    @SerializedName("backdrop_path")
    var backdropPath: String? = null,
    @SerializedName("genre_ids")
    var genreIds: List<Long>? = null,
    @Expose
    var id: Long? = null,
    @SerializedName("original_language")
    var originalLanguage: String? = null,
    @SerializedName("original_title")
    var originalTitle: String? = null,
    @Expose
    var overview: String? = null,
    @Expose
    var popularity: Double? = null,
    @SerializedName("poster_path")
    var posterPath: String? = null,
    @SerializedName("release_date")
    var releaseDate: String? = null,
    @Expose
    var title: String? = null,
    @Expose
    var video: Boolean? = null,
    @SerializedName("vote_average")
    var voteAverage: Double? = null,
    @SerializedName("vote_count")
    var voteCount: Long? = null,

    @SerializedName("homepage")
    var homepage: String? = null

) : Serializable {
    val thumbnailFilme: String get() = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/$backdropPath"
}