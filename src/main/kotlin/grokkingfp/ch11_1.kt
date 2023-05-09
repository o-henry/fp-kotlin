package grokkingfp

object model_11 {
    @JvmInline
    value class LocationId(val value: String)

    data class Location(val id: LocationId, val name: String, val population: Int)
    data class Attraction(val name: String, val description: String?, val location: Location)

    sealed class PopCultureSubject {
        data class Artist(val name: String, val followers: Int) : PopCultureSubject()
        data class Movie(val name: String, val boxOffice: Int) : PopCultureSubject()
    }

    data class TravelGuide(val attraction: Attraction, val subjects: List<PopCultureSubject>)
}