package fpwithkotlin.ch13

import arrow.core.None
import arrow.core.Option
import arrow.core.Some

data class Player(val name: String, val score: Int)

fun contest(p1: Player, p2: Player): Unit = // impure function
    when (val player = winner(p1, p2)) {
        is Some ->
            println("${player.value} is thet winner")

        is None ->
            println("It's a draw!")
    }

fun winner(p1: Player, p2: Player): Option<Player> =
    when {
        p1.score > p2.score -> Some(p1)
        p1.score < p2.score -> Some(p2)
        else -> None
    }