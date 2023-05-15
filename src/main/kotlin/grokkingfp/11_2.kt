package grokkingfp

/**
 * user story
 *  Pop culture travel guide
 *  The application should take a single String value: a search term for the tourist attraction that the user wants to visit and needs a travel guide for.
 *  The application needs to search for a given attraction, its description (if it exists), and its geographical location. It should prefer locations with larger populations.
 *  The application should use a location to do as follows:
 *  Find artists originating from this location, sorted by the number of social media followers
 *  Find movies that take place in this location, sorted by the box office earnings
 *  For a given tourist attraction, artists and movies form its “pop culture travel guide” that should be returned to the user. If there are more possible guides, the application needs to return the one with the highest score, which is calculated as follows:
 *  30 points for a description
 *  10 points for each artist or movie (max. 40 points)
 *  1 point for each 100,000 followers (all artists combined; max. 15 points)
 *  1 point for each $10,000,000 in box office earnings (all movies combined; max. 15 points)
 *  We will add support for more pop culture subjects in the future(e.g, video games).
 */

data class Attraction(val name: String, val description: String?, val location: Location) {}

data class Location(val id: LocationId)

@JvmInline
value class LocationId(val value: String)

sealed class PopCultureSubject {
    data class Artist(val name: String, val followers: Int) : PopCultureSubject()
    data class Movie(val name: String, val boxOffice: Int) : PopCultureSubject()
}
