package fpwithkotlin.ch09

import arrow.core.Either

/**
 * Algebra
 * Signature
 * Easy and Small
 *
 * TODO
 *  The char('a') parser will succeed only if the input is exactly the character
 *  'a', and it will return that same character 'a' as its result.
 */


interface Parsers<PE> {
    interface Parser<A>

    fun string(s: String): Parser<String>

    fun <A> or(pa: Parser<A>, pb: Parser<A>): Parser<A>

    fun char(c: Char): Parser<Char>

    fun <A> run(p: Parser<A>, input: String): Either<PE, A>

}

fun main() {
}



