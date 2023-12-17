package leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * Given a string s, return the longest
 * palindromic
 * substring in s.
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "no any value";
        }

        int ln = s.length();
        boolean[][] dp = new boolean[ln][ln];
        int start = 0;
        int max = 1;

        for (int i = 0; i < ln; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < ln - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                max = 2;
            }
        }

        for (int length = 3; length <= ln; length++) {
            for (int i = 0; i < ln - length; i++) {
                int j = i + length - 1;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    start = i;
                    max = length;
                }
            }
        }
        return s.substring(start, start + max);
    }
}
