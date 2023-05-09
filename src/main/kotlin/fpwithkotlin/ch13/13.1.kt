package fpwithkotlin.ch13

data class Player(val name: String, val score: Int)

fun contest(p1: Player, p2: Player): Unit = // impure function
    when {
        p1.score > p2.score -> // pure logic
            println("${p1.name} is the winner!") // I/O

        p1.score < p2.score ->
            println("${p2.name} is the winner!") // I/O

        else ->
            println("It's a draw!") // I/O
    }