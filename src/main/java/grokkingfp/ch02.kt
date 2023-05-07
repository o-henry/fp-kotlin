package grokkingfp

class ch02 {
    class ShoppingCart(
        private val items: List<String> = emptyList()
    ) {

        // private boolean bookAdded = false - removing the state
        fun addItem(items: List<String>, item: String): List<String> = items.plus(item)

        fun getItems(): List<String> = ArrayList(items)

        fun removeItem(items: List<String>, item: String): List<String> = items.minus(item)

        companion object {
            fun getDiscountPercentage(items: List<String>): Int =
                if (items.contains("Book")) {
                    5
                } else {
                    0
                }
        }
    }


}

fun main(args: Array<String>) {
    println(ch02.ShoppingCart.getDiscountPercentage(listOf("Apple")))

    println(ch02.ShoppingCart.getDiscountPercentage(listOf("Apple", "Book")))
}