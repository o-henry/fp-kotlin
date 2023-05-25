package grokkingfp

data class Book(val title: String, val authors: List<String>)

val books = listOf(
    Book("FP in Scala", listOf("Chiusano", "Bjarnason")),
    Book("The Hobbit", listOf("Tolkien")),
    Book("Modern Java in Action", listOf("Urma", "Fusco", "Mycroft"))
)

data class Movie(val title: String)

fun bookAdaptations(author: String): List<Movie> =
    if (author == "Tolkien") listOf(Movie("An Unexpected Journey"), Movie("The Desolation of Smaug"))
    else emptyList()


fun main() {
    val count =
        books
            .map(Book::title) // List[String], [FP in Scala, The Hobbit, Modern Java in Action]
            .filter { it.contains("Scala") } // List[String], [FP in Scala]
            .size // Int

    println(count)


    val tolkein =
        books
            .flatMap(Book::authors)
            .flatMap { bookAdaptations(it) }

    println(tolkein)

    

}
