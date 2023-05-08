package grokkingfp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ch04 {
    /**
     * user story
     * The score of a given word is calculated by giving one point for each letter that is not an 'a'
     * For a given list of words, return a sorted list that starts with the highest-scoring word
     */

    static int score(String word) {
        return word.replaceAll("a", "").length();
    }

    static Comparator<String> scoreComparator = new Comparator<String>() {
        public int compare(String w1, String w2) {
            return Integer.compare(score(w2), score(w1));
        }
    };

    static List<String> rankedWords(List<String> words) {
        words.sort(scoreComparator);
        return words;
    }

    @Test
    void scored_letter() {
        List<String> words = Arrays.asList("ada", "haskell", "kotlin", "java", "rust");
        List<String> ranking = rankedWords(words);
        assertEquals(ranking, Arrays.asList("haskell", "kotlin", "rust", "java", "ada"));
    }
}
