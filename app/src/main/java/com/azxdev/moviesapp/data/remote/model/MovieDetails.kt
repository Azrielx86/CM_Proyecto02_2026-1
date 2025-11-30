package com.azxdev.moviesapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    val ok: Boolean,
    @SerializedName("error_code")
    val errorCode: Long,
    val description: String,
    val short: Short,
    val imdbId: String,
)

data class Short(
    @SerializedName("@context")
    val context: String,
    @SerializedName("@type")
    val type: String,
    val url: String,
    val name: String,
    val image: String,
    val description: String,
    val review: Review,
    val aggregateRating: AggregateRating,
    val contentRating: String,
    val genre: List<String>,
    val datePublished: String,
    val keywords: String,
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
data class ProductionStatus(
    val currentProductionStage: CurrentProductionStage,
    val productionStatusHistory: List<ProductionStatusHistory>,
    val restriction: Any?,
    @SerializedName("__typename")
    val typename: String,
)

data class CurrentProductionStage(
    val id: String,
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class ProductionStatusHistory(
    val status: Status,
    @SerializedName("__typename")
    val typename: String,
)

data class Status(
    val id: String,
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class ExternalLinks(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

