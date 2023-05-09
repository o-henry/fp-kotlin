package fpwithkotlin.ch13

interface IO {
    companion object {
        fun empty(): IO = object : IO {
            override fun run(): Unit = Unit
        }
    }

    fun run(): Unit

    fun assoc(io: IO): IO = object : IO {
        override fun run() {
            this@IO.run()
            io.run()

        }
    }
}

fun stdout(msg: String): IO =
    object : IO {
        override fun run(): Unit = println(msg)
    }

fun _contest(p1: Player, p2: Player): IO =
    stdout(winnerMsg(winner(p1, p2)))