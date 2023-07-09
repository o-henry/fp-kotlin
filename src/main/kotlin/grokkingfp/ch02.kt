package grokkingfp

class ch02 {
    class ShoppingCart(
        private val items: List<String> = emptyList()
    ) {

        // private boolean bookAdded = false - removing the state
        fun addItem(items: List<String>, item: String): ShoppingCart {
            items.plus(item)
            return ShoppingCart(items)
        }

        fun getItems(): List<String> = items

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

    val cart = ch02.ShoppingCart(listOf("Apple", "Book"))
    val updatedCart = cart.addItem(listOf("Apple", "Book"), "Banana")

    println(updatedCart.getItems())
}