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
    val main: Main,
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

data class Top(
    val id: String,
    val productionStatus: ProductionStatus,
    val externalLinks: ExternalLinks,
    val metacritic: Any?,
    val keywords: Keywords,
    val credits: Credits,
    val engagementStatistics: EngagementStatistics,
    val titleText: TitleText,
    val titleType: TitleType,
    val originalTitleText: OriginalTitleText,
    val certificate: Certificate,
    val releaseYear: ReleaseYear,
    val releaseDate: ReleaseDate,
    val runtime: Runtime,
    val canRate: CanRate,
    val ratingsSummary: RatingsSummary,
    val meterRanking: MeterRanking,
    val series: Any?,
    val isAdult: Boolean,
    val genres: Genres,
    val interests: Interests,
    val plot: Plot,
    val plotContributionLink: PlotContributionLink,
    val primaryImage: PrimaryImage,
    val images: Images,
    val videos: Videos,
    val primaryVideos: PrimaryVideos,
    val principalCreditsV2: List<PrincipalCreditsV2>,
    val reviews: Reviews,
    val criticReviewsTotal: CriticReviewsTotal,
    val triviaTotal: TriviaTotal,
    val subNavCredits: SubNavCredits,
    val subNavReviews: SubNavReviews,
    val subNavTrivia: SubNavTrivia,
    val subNavFaqs: SubNavFaqs,
    val subNavTopQuestions: SubNavTopQuestions,
    val titleGenres: TitleGenres,
    val meta: Meta,
    val castPageTitle: CastPageTitle,
    val creatorsPageTitle: List<CreatorsPageTitle>,
    val directorsPageTitle: List<Any?>,
    val countriesOfOrigin: CountriesOfOrigin,
    val production: Production,
    val featuredReviews: FeaturedReviews,
    val castV2: List<CastV2>,
    val crewV2: List<CrewV2>,
    @SerializedName("__typename")
    val typename: String,
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

data class Keywords(
    val total: Long,
    val edges: List<Edge>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge(
    val node: Node,
    @SerializedName("__typename")
    val typename: String,
)

data class Node(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Credits(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class EngagementStatistics(
    val watchlistStatistics: WatchlistStatistics,
    @SerializedName("__typename")
    val typename: String,
)

data class WatchlistStatistics(
    val displayableCount: DisplayableCount,
    @SerializedName("__typename")
    val typename: String,
)

data class DisplayableCount(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class TitleText(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class TitleType(
    val displayableProperty: DisplayableProperty,
    val text: String,
    val id: String,
    val isSeries: Boolean,
    val isEpisode: Boolean,
    val categories: List<Category>,
    val canHaveEpisodes: Boolean,
    @SerializedName("__typename")
    val typename: String,
)

data class DisplayableProperty(
    val value: Value,
    @SerializedName("__typename")
    val typename: String,
)

data class Value(
    val plainText: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Category(
    val value: String,
    @SerializedName("__typename")
    val typename: String,
)

data class OriginalTitleText(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Certificate(
    val rating: String,
    @SerializedName("__typename")
    val typename: String,
)

data class ReleaseYear(
    val year: Long,
    val endYear: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class ReleaseDate(
    val day: Long,
    val month: Long,
    val year: Long,
    val country: Country,
    @SerializedName("__typename")
    val typename: String,
)

data class Country(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Runtime(
    val seconds: Long,
    val displayableProperty: DisplayableProperty2,
    @SerializedName("__typename")
    val typename: String,
)

data class DisplayableProperty2(
    val value: Value2,
    @SerializedName("__typename")
    val typename: String,
)

data class Value2(
    val plainText: String,
    @SerializedName("__typename")
    val typename: String,
)

data class CanRate(
    val isRatable: Boolean,
    @SerializedName("__typename")
    val typename: String,
)

data class RatingsSummary(
    val aggregateRating: Double,
    val voteCount: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class MeterRanking(
    val currentRank: Long,
    val rankChange: RankChange,
    @SerializedName("__typename")
    val typename: String,
)

data class RankChange(
    val changeDirection: String,
    val difference: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Genres(
    val genres: List<Genre>,
    @SerializedName("__typename")
    val typename: String,
)

data class Genre(
    val text: String,
    val id: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Interests(
    val edges: List<Edge2>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge2(
    val node: Node2,
    @SerializedName("__typename")
    val typename: String,
)

data class Node2(
    val id: String,
    val primaryText: PrimaryText,
    @SerializedName("__typename")
    val typename: String,
)

data class PrimaryText(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Plot(
    val plotText: PlotText,
    val language: Language,
    @SerializedName("__typename")
    val typename: String,
)

data class PlotText(
    val plainText: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Language(
    val id: String,
    @SerializedName("__typename")
    val typename: String,
)

data class PlotContributionLink(
    val url: String,
    @SerializedName("__typename")
    val typename: String,
)

data class PrimaryImage(
    val id: String,
    val width: Long,
    val height: Long,
    val url: String,
    val caption: Caption,
    @SerializedName("__typename")
    val typename: String,
)

data class Caption(
    val plainText: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Images(
    val total: Long,
    val edges: List<Edge3>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge3(
    val node: Node3,
    @SerializedName("__typename")
    val typename: String,
)

data class Node3(
    val id: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Videos(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class PrimaryVideos(
    val edges: List<Edge4>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge4(
    val node: Node4,
    @SerializedName("__typename")
    val typename: String,
)

data class Node4(
    val id: String,
    val createdDate: String,
    val isMature: Boolean,
    val runtime: Runtime2,
    val name: Name,
    val description: Description,
    val timedTextTracks: List<Any?>,
    val recommendedTimedTextTrack: Any?,
    val thumbnail: Thumbnail2,
    val primaryTitle: PrimaryTitle,
    @SerializedName("playbackURLs")
    val playbackUrls: List<PlaybackUrl>,
    val contentType: ContentType,
    @SerializedName("previewURLs")
    val previewUrls: List<PreviewUrl>,
    @SerializedName("__typename")
    val typename: String,
)

data class Runtime2(
    val value: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Name(
    val value: String,
    val language: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Description(
    val value: String,
    val language: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Thumbnail2(
    val url: String,
    val height: Long,
    val width: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class PrimaryTitle(
    val id: String,
    val titleText: TitleText2,
    val originalTitleText: OriginalTitleText2,
    val releaseYear: ReleaseYear2,
    @SerializedName("__typename")
    val typename: String,
)

data class TitleText2(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class OriginalTitleText2(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class ReleaseYear2(
    val year: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class PlaybackUrl(
    val displayName: DisplayName,
    val videoMimeType: String,
    val videoDefinition: String,
    val url: String,
    val metricDimensions: List<MetricDimension>,
    @SerializedName("__typename")
    val typename: String,
)

data class DisplayName(
    val value: String,
    val language: String,
    @SerializedName("__typename")
    val typename: String,
)

data class MetricDimension(
    val name: String,
    val value: String,
    @SerializedName("__typename")
    val typename: String,
)

data class ContentType(
    val id: String,
    val displayName: DisplayName2,
    @SerializedName("__typename")
    val typename: String,
)

data class DisplayName2(
    val value: String,
    @SerializedName("__typename")
    val typename: String,
)

data class PreviewUrl(
    val displayName: DisplayName3,
    val videoMimeType: String,
    val videoDefinition: String,
    val url: String,
    @SerializedName("__typename")
    val typename: String,
)

data class DisplayName3(
    val value: String,
    val language: String,
    @SerializedName("__typename")
    val typename: String,
)

data class PrincipalCreditsV2(
    val totalCredits: Long,
    val grouping: Grouping,
    val credits: List<Credit>,
    @SerializedName("__typename")
    val typename: String,
)

data class Grouping(
    val text: String,
    val groupingId: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Credit(
    val name: Name2,
    @SerializedName("__typename")
    val typename: String,
)

data class Name2(
    val nameText: NameText,
    val id: String,
    @SerializedName("__typename")
    val typename: String,
)

data class NameText(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Reviews(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class CriticReviewsTotal(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class TriviaTotal(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class SubNavCredits(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class SubNavReviews(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class SubNavTrivia(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class SubNavFaqs(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class SubNavTopQuestions(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class TitleGenres(
    val genres: List<Genre2>,
    @SerializedName("__typename")
    val typename: String,
)

data class Genre2(
    val genre: Genre3,
    @SerializedName("__typename")
    val typename: String,
)

data class Genre3(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Meta(
    val canonicalId: String,
    val publicationStatus: String,
    @SerializedName("__typename")
    val typename: String,
)

data class CastPageTitle(
    val edges: List<Edge5>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge5(
    val node: Node5,
    @SerializedName("__typename")
    val typename: String,
)

data class Node5(
    val name: Name3,
    @SerializedName("__typename")
    val typename: String,
)

data class Name3(
    val id: String,
    val nameText: NameText2,
    @SerializedName("__typename")
    val typename: String,
)

data class NameText2(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class CreatorsPageTitle(
    val credits: List<Credit2>,
    @SerializedName("__typename")
    val typename: String,
)

data class Credit2(
    val name: Name4,
    @SerializedName("__typename")
    val typename: String,
)

data class Name4(
    val id: String,
    val nameText: NameText3,
    @SerializedName("__typename")
    val typename: String,
)

data class NameText3(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class CountriesOfOrigin(
    val countries: List<Country2>,
    @SerializedName("__typename")
    val typename: String,
)

data class Country2(
    val id: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Production(
    val edges: List<Edge6>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge6(
    val node: Node6,
    @SerializedName("__typename")
    val typename: String,
)

data class Node6(
    val company: Company,
    @SerializedName("__typename")
    val typename: String,
)

data class Company(
    val id: String,
    val companyText: CompanyText,
    @SerializedName("__typename")
    val typename: String,
)

data class CompanyText(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class FeaturedReviews(
    val edges: List<Edge7>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge7(
    val node: Node7,
    @SerializedName("__typename")
    val typename: String,
)

data class Node7(
    val author: Author2,
    val summary: Summary,
    val text: Text,
    val authorRating: Long,
    val submissionDate: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Author2(
    val nickName: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Summary(
    val originalText: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Text(
    val originalText: OriginalText,
    @SerializedName("__typename")
    val typename: String,
)

data class OriginalText(
    val plainText: String,
    @SerializedName("__typename")
    val typename: String,
)

data class CastV2(
    val credits: List<Credit3>,
    @SerializedName("__typename")
    val typename: String,
)

data class Credit3(
    val name: Name5,
    @SerializedName("__typename")
    val typename: String,
)

data class Name5(
    val id: String,
    val nameText: NameText4,
    @SerializedName("__typename")
    val typename: String,
)

data class NameText4(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class CrewV2(
    val grouping: Grouping2,
    val credits: List<Credit4>,
    @SerializedName("__typename")
    val typename: String,
)

data class Grouping2(
    val groupingId: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Credit4(
    val name: Name6,
    @SerializedName("__typename")
    val typename: String,
)

data class Name6(
    val id: String,
    val nameText: NameText5,
    @SerializedName("__typename")
    val typename: String,
)

data class NameText5(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Main(
    val id: String,
    val wins: Wins,
    val nominationsExcludeWins: NominationsExcludeWins,
    val prestigiousAwardSummary: PrestigiousAwardSummary,
    val ratingsSummary: RatingsSummary2,
    val episodes: Episodes,
    val videos: Videos2,
    val videoStrip: VideoStrip,
    val titleMainImages: TitleMainImages,
    val productionStatus: ProductionStatus2,
    val primaryImage: PrimaryImage2,
    val inIframeAddLink: InIframeAddLink,
    val notInIframeAddLink: NotInIframeAddLink,
    val titleType: TitleType2,
    val castV2: List<CastV22>,
    val crewV2: List<CrewV22>,
    val titleText: TitleText3,
    val originalTitleText: OriginalTitleText3,
    val canRate: CanRate2,
    val reviews: Reviews2,
    val aggregateRatingsBreakdown: AggregateRatingsBreakdown,
    val featuredReviews: FeaturedReviews2,
    val reviewSummary: ReviewSummary,
    val isAdult: Boolean,
    val moreLikeThisTitles: MoreLikeThisTitles,
    val relatedInterests: RelatedInterests,
    val triviaTotal: TriviaTotal2,
    val trivia: Trivia,
    val goofsTotal: GoofsTotal,
    val goofs: Goofs,
    val quotesTotal: QuotesTotal,
    val quotes: Quotes,
    val crazyCredits: CrazyCredits,
    val alternateVersions: AlternateVersions,
    val connections: Connections,
    val soundtrack: Soundtrack,
    val topQuestions: TopQuestions,
    val faqs: Faqs,
    val releaseDate: ReleaseDate2,
    val countriesDetails: CountriesDetails,
    val detailsExternalLinks: DetailsExternalLinks,
    val spokenLanguages: SpokenLanguages,
    val akas: Akas,
    val filmingLocations: FilmingLocations,
    val production: Production2,
    val companies: Companies,
    val productionBudget: Any?,
    val lifetimeGross: Any?,
    val openingWeekendGross: Any?,
    val worldwideGross: Any?,
    val technicalSpecifications: TechnicalSpecifications,
    val runtime: Runtime5,
    val series: Any?,
    @SerializedName("__typename")
    val typename: String,
)

data class Wins(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class NominationsExcludeWins(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class PrestigiousAwardSummary(
    val nominations: Long,
    val wins: Long,
    val award: Award,
    @SerializedName("__typename")
    val typename: String,
)

data class Award(
    val text: String,
    val id: String,
    val event: Event,
    @SerializedName("__typename")
    val typename: String,
)

data class Event(
    val id: String,
    @SerializedName("__typename")
    val typename: String,
)

data class RatingsSummary2(
    val topRanking: TopRanking,
    @SerializedName("__typename")
    val typename: String,
    val aggregateRating: Double,
    val voteCount: Long,
    val notificationText: Any?,
)

data class TopRanking(
    val id: String,
    val text: Text2,
    val rank: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Text2(
    val value: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Episodes(
    val episodes: Episodes2,
    val seasons: List<Season>,
    val years: List<Year>,
    val totalEpisodes: TotalEpisodes,
    val unknownSeasonEpisodes: UnknownSeasonEpisodes,
    val topRated: TopRated,
    @SerializedName("__typename")
    val typename: String,
)

data class Episodes2(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Season(
    val number: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Year(
    val year: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class TotalEpisodes(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class UnknownSeasonEpisodes(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class TopRated(
    val edges: List<Edge8>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge8(
    val node: Node8,
    @SerializedName("__typename")
    val typename: String,
)

data class Node8(
    val ratingsSummary: RatingsSummary3,
    @SerializedName("__typename")
    val typename: String,
)

data class RatingsSummary3(
    val aggregateRating: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Videos2(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class VideoStrip(
    val edges: List<Edge9>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge9(
    val node: Node9,
    @SerializedName("__typename")
    val typename: String,
)

data class Node9(
    val id: String,
    val contentType: ContentType2,
    val name: Name7,
    val runtime: Runtime3,
    val thumbnail: Thumbnail3,
    @SerializedName("__typename")
    val typename: String,
)

data class ContentType2(
    val displayName: DisplayName4,
    @SerializedName("__typename")
    val typename: String,
)

data class DisplayName4(
    val value: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Name7(
    val value: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Runtime3(
    val value: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Thumbnail3(
    val height: Long,
    val url: String,
    val width: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class TitleMainImages(
    val total: Long,
    val edges: List<Edge10>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge10(
    val node: Node10,
    @SerializedName("__typename")
    val typename: String,
)

data class Node10(
    val id: String,
    val url: String,
    val caption: Caption2,
    val height: Long,
    val width: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Caption2(
    val plainText: String,
    @SerializedName("__typename")
    val typename: String,
)

data class ProductionStatus2(
    val currentProductionStage: CurrentProductionStage2,
    val productionStatusHistory: List<ProductionStatusHistory2>,
    val restriction: Any?,
    @SerializedName("__typename")
    val typename: String,
)

data class CurrentProductionStage2(
    val id: String,
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class ProductionStatusHistory2(
    val status: Status2,
    @SerializedName("__typename")
    val typename: String,
)

data class Status2(
    val id: String,
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class PrimaryImage2(
    val id: String,
    @SerializedName("__typename")
    val typename: String,
    val url: String,
    val width: Long,
    val height: Long,
    val caption: Caption3,
)

data class Caption3(
    val plainText: String,
    @SerializedName("__typename")
    val typename: String,
)

data class InIframeAddLink(
    val url: String,
    @SerializedName("__typename")
    val typename: String,
)

data class NotInIframeAddLink(
    val url: String,
    @SerializedName("__typename")
    val typename: String,
)

data class TitleType2(
    val id: String,
    val canHaveEpisodes: Boolean,
    @SerializedName("__typename")
    val typename: String,
)

data class CastV22(
    val grouping: Grouping3,
    val totalCredits: Long,
    val credits: List<Credit5>,
    @SerializedName("__typename")
    val typename: String,
)

data class Grouping3(
    val groupingId: String,
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Credit5(
    val name: Name8,
    val creditedRoles: CreditedRoles,
    val episodeCredits: EpisodeCredits,
    @SerializedName("__typename")
    val typename: String,
)

data class Name8(
    val id: String,
    val nameText: NameText6,
    val primaryImage: PrimaryImage3,
    @SerializedName("__typename")
    val typename: String,
)

data class NameText6(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class PrimaryImage3(
    val url: String,
    val width: Long,
    val height: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class CreditedRoles(
    val edges: List<Edge11>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge11(
    val node: Node11,
    @SerializedName("__typename")
    val typename: String,
)

data class Node11(
    val category: Category2,
    val attributes: Any?,
    val characters: Characters,
    @SerializedName("__typename")
    val typename: String,
)

data class Category2(
    val categoryId: String,
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Characters(
    val edges: List<Edge12>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge12(
    val node: Node12,
    @SerializedName("__typename")
    val typename: String,
)

data class Node12(
    val name: String,
    @SerializedName("__typename")
    val typename: String,
)

data class EpisodeCredits(
    val total: Long,
    val yearRange: YearRange,
    @SerializedName("__typename")
    val typename: String,
)

data class YearRange(
    val year: Long,
    val endYear: Long?,
    @SerializedName("__typename")
    val typename: String,
)

data class CrewV22(
    val totalCredits: Long,
    val grouping: Grouping4,
    val credits: List<Credit6>,
    @SerializedName("__typename")
    val typename: String,
)

data class Grouping4(
    val groupingId: String,
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Credit6(
    val name: Name9,
    @SerializedName("__typename")
    val typename: String,
)

data class Name9(
    val id: String,
    val nameText: NameText7,
    @SerializedName("__typename")
    val typename: String,
)

data class NameText7(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class TitleText3(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class OriginalTitleText3(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class CanRate2(
    val isRatable: Boolean,
    @SerializedName("__typename")
    val typename: String,
)

data class Reviews2(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class AggregateRatingsBreakdown(
    val histogram: Histogram,
    @SerializedName("__typename")
    val typename: String,
)

data class Histogram(
    val histogramValues: List<HistogramValue>,
    @SerializedName("__typename")
    val typename: String,
)

data class HistogramValue(
    val rating: Long,
    val voteCount: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class FeaturedReviews2(
    val edges: List<Edge13>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge13(
    val node: Node13,
    @SerializedName("__typename")
    val typename: String,
)

data class Node13(
    val id: String,
    val author: Author3,
    val summary: Summary2,
    val text: Text3,
    val title: Title,
    val authorRating: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Author3(
    val userId: String,
    val username: Username,
    @SerializedName("__typename")
    val typename: String,
)

data class Username(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Summary2(
    val originalText: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Text3(
    val originalText: OriginalText2,
    @SerializedName("__typename")
    val typename: String,
)

data class OriginalText2(
    val plaidHtml: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Title(
    val id: String,
    @SerializedName("__typename")
    val typename: String,
)

data class ReviewSummary(
    val overall: Overall,
    val themes: List<Theme>,
    @SerializedName("__typename")
    val typename: String,
)

data class Overall(
    val medium: Medium,
    @SerializedName("__typename")
    val typename: String,
)

data class Medium(
    val value: Value3,
    @SerializedName("__typename")
    val typename: String,
)

data class Value3(
    val plaidHtml: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Theme(
    val themeId: String,
    val label: Label,
    val sentiment: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Label(
    val value: String,
    @SerializedName("__typename")
    val typename: String,
)

data class MoreLikeThisTitles(
    val edges: List<Edge14>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge14(
    val node: Node14,
    @SerializedName("__typename")
    val typename: String,
)

data class Node14(
    val id: String,
    val titleText: TitleText4,
    val titleType: TitleType3,
    val originalTitleText: OriginalTitleText4,
    val primaryImage: PrimaryImage4,
    val releaseYear: ReleaseYear3,
    val ratingsSummary: RatingsSummary4,
    val runtime: Runtime4,
    val certificate: Certificate2,
    val canRate: CanRate3,
    val titleGenres: TitleGenres2,
    @SerializedName("__typename")
    val typename: String,
)

data class TitleText4(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class TitleType3(
    val id: String,
    val text: String,
    val canHaveEpisodes: Boolean,
    val displayableProperty: DisplayableProperty3,
    @SerializedName("__typename")
    val typename: String,
)

data class DisplayableProperty3(
    val value: Value4,
    @SerializedName("__typename")
    val typename: String,
)

data class Value4(
    val plainText: String,
    @SerializedName("__typename")
    val typename: String,
)

data class OriginalTitleText4(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class PrimaryImage4(
    val id: String,
    val width: Long,
    val height: Long,
    val url: String,
    val caption: Caption4,
    @SerializedName("__typename")
    val typename: String,
)

data class Caption4(
    val plainText: String,
    @SerializedName("__typename")
    val typename: String,
)

data class ReleaseYear3(
    val year: Long,
    val endYear: Long?,
    @SerializedName("__typename")
    val typename: String,
)

data class RatingsSummary4(
    val aggregateRating: Double,
    val voteCount: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Runtime4(
    val seconds: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Certificate2(
    val rating: String,
    @SerializedName("__typename")
    val typename: String,
)

data class CanRate3(
    val isRatable: Boolean,
    @SerializedName("__typename")
    val typename: String,
)

data class TitleGenres2(
    val genres: List<Genre4>,
    @SerializedName("__typename")
    val typename: String,
)

data class Genre4(
    val genre: Genre5,
    @SerializedName("__typename")
    val typename: String,
)

data class Genre5(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class RelatedInterests(
    val edges: List<Edge15>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge15(
    val node: Node15,
    @SerializedName("__typename")
    val typename: String,
)

data class Node15(
    val id: String,
    val primaryText: PrimaryText2,
    val primaryImage: PrimaryImage5,
    val visibilityLevel: String,
    @SerializedName("__typename")
    val typename: String,
)

data class PrimaryText2(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class PrimaryImage5(
    val caption: Caption5,
    val width: Long,
    val height: Long,
    val url: String,
    val id: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Caption5(
    val plainText: String,
    @SerializedName("__typename")
    val typename: String,
)

data class TriviaTotal2(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Trivia(
    val edges: List<Edge16>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge16(
    val node: Node16,
    @SerializedName("__typename")
    val typename: String,
)

data class Node16(
    val text: Text4,
    val trademark: Any?,
    val relatedNames: Any?,
    @SerializedName("__typename")
    val typename: String,
)

data class Text4(
    val plaidHtml: String,
    @SerializedName("__typename")
    val typename: String,
)

data class GoofsTotal(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Goofs(
    val edges: List<Edge17>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge17(
    val node: Node17,
    @SerializedName("__typename")
    val typename: String,
)

data class Node17(
    val text: Text5,
    @SerializedName("__typename")
    val typename: String,
)

data class Text5(
    val plaidHtml: String,
    @SerializedName("__typename")
    val typename: String,
)

data class QuotesTotal(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Quotes(
    val edges: List<Edge18>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge18(
    val node: Node18,
    @SerializedName("__typename")
    val typename: String,
)

data class Node18(
    val lines: List<Line>,
    @SerializedName("__typename")
    val typename: String,
)

data class Line(
    val characters: List<Character>,
    val text: String,
    val stageDirection: Any?,
    @SerializedName("__typename")
    val typename: String,
)

data class Character(
    val character: String,
    val name: Name10,
    @SerializedName("__typename")
    val typename: String,
)

data class Name10(
    val id: String,
    @SerializedName("__typename")
    val typename: String,
)

data class CrazyCredits(
    val edges: List<Edge19>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge19(
    val node: Node19,
    @SerializedName("__typename")
    val typename: String,
)

data class Node19(
    val text: Text6,
    @SerializedName("__typename")
    val typename: String,
)

data class Text6(
    val plaidHtml: String,
    @SerializedName("__typename")
    val typename: String,
)

data class AlternateVersions(
    val total: Long,
    val edges: List<Edge20>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge20(
    val node: Node20,
    @SerializedName("__typename")
    val typename: String,
)

data class Node20(
    val text: Text7,
    @SerializedName("__typename")
    val typename: String,
)

data class Text7(
    val plaidHtml: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Connections(
    val edges: List<Edge21>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge21(
    val node: Node21,
    @SerializedName("__typename")
    val typename: String,
)

data class Node21(
    val associatedTitle: AssociatedTitle,
    val category: Category3,
    @SerializedName("__typename")
    val typename: String,
)

data class AssociatedTitle(
    val id: String,
    val releaseYear: ReleaseYear4,
    val titleText: TitleText5,
    val originalTitleText: OriginalTitleText5,
    val series: Series,
    @SerializedName("__typename")
    val typename: String,
)

data class ReleaseYear4(
    val year: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class TitleText5(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class OriginalTitleText5(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Series(
    val series: Series2,
    @SerializedName("__typename")
    val typename: String,
)

data class Series2(
    val titleText: TitleText6,
    val originalTitleText: OriginalTitleText6,
    @SerializedName("__typename")
    val typename: String,
)

data class TitleText6(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class OriginalTitleText6(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Category3(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Soundtrack(
    val edges: List<Edge22>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge22(
    val node: Node22,
    @SerializedName("__typename")
    val typename: String,
)

data class Node22(
    val text: String,
    val comments: List<Comment>,
    @SerializedName("__typename")
    val typename: String,
)

data class Comment(
    val plaidHtml: String,
    @SerializedName("__typename")
    val typename: String,
)

data class TopQuestions(
    val total: Long,
    val edges: List<Edge23>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge23(
    val node: Node23,
    @SerializedName("__typename")
    val typename: String,
)

data class Node23(
    val attributeId: String,
    val question: Question,
    @SerializedName("__typename")
    val typename: String,
)

data class Question(
    val plainText: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Faqs(
    val total: Long,
    val edges: List<Edge24>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge24(
    val node: Node24,
    @SerializedName("__typename")
    val typename: String,
)

data class Node24(
    val id: String,
    val question: Question2,
    @SerializedName("__typename")
    val typename: String,
)

data class Question2(
    val plainText: String,
    @SerializedName("__typename")
    val typename: String,
)

data class ReleaseDate2(
    val day: Long,
    val month: Long,
    val year: Long,
    val country: Country3,
    @SerializedName("__typename")
    val typename: String,
)

data class Country3(
    val id: String,
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class CountriesDetails(
    val countries: List<Country4>,
    @SerializedName("__typename")
    val typename: String,
)

data class Country4(
    val id: String,
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class DetailsExternalLinks(
    val edges: List<Edge25>,
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge25(
    val node: Node25,
    @SerializedName("__typename")
    val typename: String,
)

data class Node25(
    val url: String,
    val label: String,
    val externalLinkRegion: Any?,
    @SerializedName("__typename")
    val typename: String,
)

data class SpokenLanguages(
    val spokenLanguages: List<SpokenLanguage>,
    @SerializedName("__typename")
    val typename: String,
)

data class SpokenLanguage(
    val id: String,
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Akas(
    val edges: List<Edge26>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge26(
    val node: Node26,
    @SerializedName("__typename")
    val typename: String,
)

data class Node26(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class FilmingLocations(
    val edges: List<Edge27>,
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge27(
    val node: Node27,
    @SerializedName("__typename")
    val typename: String,
)

data class Node27(
    val text: String,
    val location: String,
    val attributes: List<Attribute>,
    @SerializedName("__typename")
    val typename: String,
)

data class Attribute(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Production2(
    val edges: List<Edge28>,
    @SerializedName("__typename")
    val typename: String,
)

data class Edge28(
    val node: Node28,
    @SerializedName("__typename")
    val typename: String,
)

data class Node28(
    val company: Company2,
    @SerializedName("__typename")
    val typename: String,
)

data class Company2(
    val id: String,
    val companyText: CompanyText2,
    @SerializedName("__typename")
    val typename: String,
)

data class CompanyText2(
    val text: String,
    @SerializedName("__typename")
    val typename: String,
)

data class Companies(
    val total: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class TechnicalSpecifications(
    val soundMixes: SoundMixes,
    val aspectRatios: AspectRatios,
    val colorations: Colorations,
    @SerializedName("__typename")
    val typename: String,
)

data class SoundMixes(
    val items: List<Item>,
    @SerializedName("__typename")
    val typename: String,
)

data class Item(
    val id: String,
    val text: String,
    val attributes: List<Any?>,
    @SerializedName("__typename")
    val typename: String,
)

data class AspectRatios(
    val items: List<Any?>,
    @SerializedName("__typename")
    val typename: String,
)

data class Colorations(
    val items: List<Item2>,
    @SerializedName("__typename")
    val typename: String,
)

data class Item2(
    val conceptId: String,
    val text: String,
    val attributes: List<Any?>,
    @SerializedName("__typename")
    val typename: String,
)

data class Runtime5(
    val displayableProperty: DisplayableProperty4,
    val seconds: Long,
    @SerializedName("__typename")
    val typename: String,
)

data class DisplayableProperty4(
    val value: Value5,
    @SerializedName("__typename")
    val typename: String,
)

data class Value5(
    val plainText: String,
    @SerializedName("__typename")
    val typename: String,
)
