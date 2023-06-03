package web

import arrow.core.Either
import arrow.core.flatMap
import arrow.core.getOrElse

/**
 * https://www.youtube.com/watch?v=Wojgv2MeMGU&t=1598s
 * Exception
 * @throws: ArithmeticException when b is 0.0
 * divide :: Double, Double -> Double (is lie)
 */
fun divide(a: Double, b: Double): Double = if (b == 0.0) {
    throw ArithmeticException("Cannot divide by 0")
} else {
    a / b
}

/**
 * Nullability
 * divideNullability :: Double, Double -> Double?
 */
fun divideNullability(a: Double, b: Double): Double? = if (b == 0.0) null else a / b

/**
 * Either
 */
fun divideEither(a: Double, b: Double): Either<String, Double> =
    if (b == 0.0) Either.Left("Cannot divide by zero")
    else Either.Right(a / b)


fun main() {
    // chaining the happy flow
    val result: Double = divideNullability(1.0, 0.0)
        ?.let { it * 2 }
        ?.let { divideNullability(it, 2.0) }
        ?: 0.0

    // Either
    val resultEither: Double = divideEither(6.0, 3.0)
        .map { right: Double -> right * 2 }
        .flatMap { right: Double -> divideEither(right, 2.0) }
        .getOrElse { 0.0 }

}