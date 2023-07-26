package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 * You are given an array of strings sentences, where each sentences[i] represents a single sentence.
 * Return the maximum number of words that appear in a single sentence.
 * Example 1:
 * Input: sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
 * Output: 6
 * Explanation:
 * - The first sentence, "alice and bob love leetcode", has 5 words in total.
 * - The second sentence, "i think so too", has 4 words in total.
 * - The third sentence, "this is great thanks very much", has 6 words in total.
 * Thus, the maximum number of words in a single sentence comes from the third sentence, which has 6 words.
 * Constraints:
 * 1 <= sentences.length <= 100
 * 1 <= sentences[i].length <= 100
 * sentences[i] consists only of lowercase English letters and ' ' only.
 * sentences[i] does not have leading or trailing spaces.
 * All the words in sentences[i] are separated by a single space.
 */
public class MaximumNumberOfWordsFoundInSentences_2114 {
    public static void main(String[] args) {
        String[] sentences = {
                "alice and bob love leetcode",
                "i think so too",
                "this is great thanks very much"
        };
        String[] randomInvalidLongSentencea = {generateRandomSentence()};
        int output = mostWordsFound(randomInvalidLongSentencea);
        System.out.println(output);
    }

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int MAX_SENTENCE_LENGTH = 101;

    public static int mostWordsFound(String[] sentences) {
        return Arrays.stream(sentences).peek(sentence -> {
                    if (sentence.length() > 100) {
                        throw new IllegalArgumentException("Sentence exceeds 100 characters limit, your input length: " + sentence.length());
                    }
                }).mapToInt(sentence -> sentence.split(" ").length)
                .max()
                .orElse(0);
    }

    public static String generateRandomSentence() {
        Random random = new Random();
        StringBuilder sentence = new StringBuilder();

        while (sentence.length() < MAX_SENTENCE_LENGTH) {
            char character = ALPHABET.charAt(random.nextInt(ALPHABET.length()));
            sentence.append(character);
        }
        return sentence.toString();
    }
}
