package com.azxdev.moviesapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    val ok: Boolean,
    @SerializedName("error_code")
    val errorCode: Long,
    val description: String,
    val short: Short,
    val imdbId: String,
    val top: Top,
    val main: Main
)

data class Short(
    @SerializedName("@context")
    val context: String,
    @SerializedName("@type")
    val type: String,
    val url: String,
    val name: String?,
    val image: String?,
    val description: String?,
    val review: Review?,
    val aggregateRating: AggregateRating?,
    val contentRating: String?,
    val genre: List<String>,
    val datePublished: String?,
    val keywords: String?,
    val creator: List<Creator>,
    val trailer: Trailer,
)

data class Review(
    @SerializedName("@type")
    val type: String,
    val itemReviewed: ItemReviewed,
    val author: Author,
    val dateCreated: String,
    val inLanguage: String,
    val name: String,
    val reviewBody: String,
    val reviewRating: ReviewRating,
)

data class ItemReviewed(
    @SerializedName("@type")
    val type: String,
    val url: String,
)

data class Author(
    @SerializedName("@type")
    val type: String,
    val name: String,
)

data class ReviewRating(
    @SerializedName("@type")
    val type: String,
    val worstRating: Long,
    val bestRating: Long,
    val ratingValue: Long,
)

data class AggregateRating(
    @SerializedName("@type")
    val type: String,
    val ratingCount: Long,
    val bestRating: Long,
    val worstRating: Long,
    val ratingValue: Double,
)

data class Creator(
    @SerializedName("@type")
    val type: String,
    val url: String,
)

data class Trailer(
    @SerializedName("@type")
    val type: String,
    val name: String,
    val embedUrl: String,
    val thumbnail: Thumbnail,
    val thumbnailUrl: String,
    val url: String,
    val description: String,
    val duration: String,
    val uploadDate: String,
)

data class Thumbnail(
    @SerializedName("@type")
    val type: String,
    val contentUrl: String,
)

data class Main(

    val castV2: List<CastV2>,
    val akas: Akas,
)

data class CastV2(
    val credits: List<Credit>,
)


data class Credit(
    val name: Name
)

data class Name(
    val id: String,
    val nameText: NameText?,
    val primaryImage: PrimaryImage?,
)

data class NameText(
    val text: String?,
)

data class PrimaryImage(
    val url: String?,
    val width: Long?,
    val height: Long?,
)

data class Akas(
    val edges: List<AkaEdge?>
)

data class AkaEdge(
    val node: AkaNode?,
)

data class AkaNode(
    val text: String?,
)

data class Top(
    val releaseYear: ReleaseYear,
    val releaseDate: ReleaseDate
)

data class ReleaseYear(
    val year: Long,
    val endYear: Long,
)

data class ReleaseDate(
    val day: Long,
    val month: Long,
    val year: Long
){
    override fun toString(): String {
        return "$day/$month/$year"
    }
}