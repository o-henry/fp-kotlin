package grokkingfp

class ch07_1 {
    // kotiln version opaque type
// inline class
    inline class Meter(val value: Double) {
        fun toCentimeter(): Double = value * 100
    }

    // value class
    @JvmInline
    value class _Meter(val value: Double) {
        fun toCentimeter(): Double = value * 100
    }
}