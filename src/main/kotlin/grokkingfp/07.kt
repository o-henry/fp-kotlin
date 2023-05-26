package grokkingfp

/**
 * user story
 * The function should be able to search through a list of music artists.
 * Each search should support a different combination of conditions: by genre, by origin (location), and by period in which they were active.
 * Each music artist has a name, genre, origin, year their career started, and a year they stopped performing (if they are not still active).
 */


@JvmInline
value class Genre(val value: String) {
    val name: String
        get() = value
}

@JvmInline
value class YearsActiveStart(val value: Int)

@JvmInline
value class YearsActiveEnd(val value: Int)

@JvmInline
value class Location(private val value: String) {
    init {
        require(value.length in 2..20)
    }

    val name: String
        get() = value
    // fun name(): String = value
}

// data class
data class Artist(
    val name: String,
    val genre: Genre,
    val origin: Location,
    val yearsActiveStart: YearsActiveStart,
    val yearsActiveEnd: YearsActiveEnd,
)


val artists = listOf(
    Artist(
        "Metallica",
        Genre("Heavy Metal"),
        Location("U.S."),
        YearsActiveStart(1981),
        YearsActiveEnd(0)
    ),
    Artist(
        "Led Zeppelin",
        Genre("Hard Rock"),
        Location("England"),
        YearsActiveStart(1968),
        YearsActiveEnd(1980)
    ),
    Artist(
        "Bee Gees",
        Genre("Pop"),
        Location("England"),
        YearsActiveStart(1958),
        YearsActiveEnd(2003)
    ),
)


fun main() {
    val us: Location = Location("U.S")
    println(us)

    // usage come first and implementation comes last. (like a TDD)
    searchArtists(
        artists,
        listOf("Pop"),
        listOf("England"),
        true,
        1950,
        2022
    ) // expected : → List(Artist("Bee Gees", "Pop", "England", 1958, false, 2003))
}

// kotiln version opaque type
@JvmInline
value class Meter(val value: Double) {
    fun toCentimeter(): Double = value * 100
}


fun searchArtists(
    artist: List<Artist>,
    genres: List<String>,
    location: List<String>,
    searchByActiveYears: Boolean,
    activeAfter: Int,
    activeBefore: Int,
): List<Artist> {
    TODO()
}