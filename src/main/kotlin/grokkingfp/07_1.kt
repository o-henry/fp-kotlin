package grokkingfp

/**
 * user story
 * Playlist has a name, a kind, and a list of songs.
 * There are three kinds of playlists: curated by a user, based on a particular artist, and based on a specific set of genres.
 * A song has an artist and a name.
 * A user has a name.
 * An artist has a name.
 * There are only three music genres: use your three favorite genres.
 */
object model {
    @JvmInline
    value class User(val name: String)

    @JvmInline
    value class Artist(val name: String)
    
    data class Song(val artist: Artist, val title: String)

    enum class MusicGenre {
        House,
        Funk,
        HipHop
    }

    sealed class PlaylistKind {
        data class CuratedByUser(val user: User) : PlaylistKind()
        data class BasedOnArtist(val artist: Artist) : PlaylistKind()
        data class BasedOnGenres(val genres: Set<MusicGenre>) : PlaylistKind()
    }

    data class Playlist(val name: String, val kind: PlaylistKind, val songs: List<Song>)
}