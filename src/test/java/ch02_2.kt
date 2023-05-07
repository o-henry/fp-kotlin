import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestingPureFunction {
    private fun increment(x: Int): Int = x + 1


    @Test
    fun `increment test`() {
        assertEquals(increment(5), 6)
    }

    private fun add(a: Int, b: Int): Int = a + b

    @Test
    fun `add test`() {
        assertEquals(add(2, 3), 5)
    }


    private fun wordScore(s: String): Int = s.replace("a", "").length

    @Test
    fun `word score test`() {
        assertEquals(wordScore("abcde"), 4)
    }

    private fun getTipPercentage(names: List<String>): Int = when {
        names.size > 5 -> 20
        names.size > 0 -> 10
        else -> 0
    }

    @Test
    fun `get tip percentage test`() {
        assertEquals(getTipPercentage(listOf("henry", "jae", "shin")), 10)
        assertEquals(getTipPercentage(listOf("henry", "jae", "shin", "haeng", "sung")), 10)
        assertEquals(getTipPercentage(listOf("henry", "jae", "shin", "haeng", "sung", "joe")), 20)
        assertEquals(getTipPercentage(listOf()), 0)
    }

    private fun getFirstCharacter(s: String): Char =
        when (s) {
            "" -> ' '
            else -> s[0]
        }


    @Test
    fun `get first character test`() {
        assertEquals(getFirstCharacter("henry"), 'h')
        assertEquals(getFirstCharacter(""), ' ')
    }


}
