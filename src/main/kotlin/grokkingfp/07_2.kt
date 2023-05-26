package grokkingfp.grokkingfp


import grokkingfp.model.Artist
import grokkingfp.model.Playlist
import grokkingfp.model.PlaylistKind.BasedOnArtist
import grokkingfp.model.PlaylistKind.BasedOnGenres
import grokkingfp.model.PlaylistKind.CuratedByUser
import grokkingfp.model.Song
import grokkingfp.model.User
import grokkingfp.model.MusicGenre

/**
 * user story
 * Playlist has a name, a kind, and a list of songs.
 * There are three kinds of playlists: curated by a user, based on a particular artist, and based on a specific set of genres.
 * A song has an artist and a name.
 * A user has a name.
 * An artist has a name.
 * There are only three music genres: use your three favorite genres.
 */


fun main() {
    val fooFighters = Artist("Foo Fighters")
    val playlist1 = Playlist(
        "This is Foo Fighters",
        BasedOnArtist(fooFighters),
        listOf(Song(fooFighters, "Breakout"), Song(fooFighters, "Learn To Fly"))
    )

    val playlist2 = Playlist(
        "Deep Focus",
        BasedOnGenres(setOf(MusicGenre.House, MusicGenre.Funk)),
        listOf(Song(Artist("Daft Punk"), "One More Time"), Song(Artist("The Chemical Brothers"), "Hey Boy Hey Girl"))
    )

    val playlist3 = Playlist(
        "My Playlist",
        CuratedByUser(User("Michał Płachta")),
        listOf(Song(fooFighters, "My Hero"), Song(Artist("Iron Maiden"), "The Trooper"))
    )

    // It should return some songs from given playlists, namely, songs performed by the artist from user-based playlists plus all songs
    // from artist-based playlists plus all songs from genre-based playlists.
    fun gatherSongs(playlists: List<Playlist>, artist: Artist, genre: MusicGenre): List<Song> =
        playlists.fold(emptyList()) { songs, playlist ->
            val matchingSongs = when (val kind = playlist.kind) {
                is CuratedByUser -> playlist.songs.filter { it.artist == artist }
                is BasedOnArtist -> if (kind.artist == artist) playlist.songs else emptyList()
                is BasedOnGenres -> if (kind.genres.contains(genre)) playlist.songs else emptyList()
                else -> {
                    TODO("Fix it...")
                }
            }
            songs + matchingSongs
        }

    require(
        gatherSongs(listOf(playlist1, playlist2, playlist3), fooFighters, MusicGenre.Funk)
                == playlist1.songs + playlist2.songs + Song(fooFighters, "My Hero")
    )
}