package grokkingfp;

public class ch01 {
    public static int calculateScore(String word) {
        int score = 0;
        for (char c : word.toCharArray()) {
            if (c != 'a') {
                score++;
            }
        }
        return score;
    }

    public static int wordScore(String word) {
        return word.replace("a", "").length();
    }

    public static String stringWithoutChar(String s, char c) {
        return s.replace(Character.toString(c), "");
    }

    public static int _wordScore(String word) {
        return stringWithoutChar(word, 'a').length();
    }

    public static void main(String[] args) {
        assert calculateScore("imperative") == 9;
        assert wordScore("declarative") == 9;

        assert calculateScore("no") == 2;
        assert wordScore("yes") == 3;
    }
}
