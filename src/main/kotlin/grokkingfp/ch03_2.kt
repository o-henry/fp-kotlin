package grokkingfp

fun abbreviate(name: String): String {
    val initial = name.substring(0, 1)
    val separator = name.indexOf(' ')
    val lastName = name.substring(separator + 1)
    return "$initial. $lastName"
}

fun firstTwo(list: List<String>): List<String> = list.slice(0..2)

fun main() {
    /**
     * TODO - check immutability
     */
    val appleBook = listOf("Apple", "Book")
    val appleBookMango = appleBook.plus("Mango")

    println(appleBook.size) // 2
    println(appleBookMango.size) // 3

}
