class Solution {
    public String longestPalindrome(String s) {
        char[] sChars = s.toCharArray();

        int m = s.length();

        // * dp[i][len + 1] means substring starting from i with length of len;
        boolean[][] dp = new boolean[m][2];
        int currCol = 0;

        int maxLen = 0;
        int ans = 0; // record start index of s

        for (int len = 0; len < m; len++) {
            for (int start = 0; start + len < m; start++) {
                int end = start + len;
                if (len == 0) {
                    dp[start][currCol] = true;
                } else if (len == 1) {
                    dp[start][currCol] = (sChars[start] == sChars[end]);
                } else {
                    dp[start][currCol] = (sChars[start] == sChars[end] && dp[start + 1][currCol]);
                }

                if (dp[start][currCol] && len + 1 > maxLen) {
                    ans = start;
                    maxLen = len + 1;
                }
            }

            currCol = 1 - currCol;
        }

        return maxLen == 0 ? "" : s.substring(ans, ans + maxLen);
    }
}




class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }

        char[] sChars = s.toCharArray();

        int start = 0;
        int end = 0;

        for (int i = 0; i < sChars.length; i++) {
            int len = Math.max(expand(sChars, i, i), expand(sChars, i, i + 1));

            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expand(char[] sChars, int i, int j) {
        while (i >= 0 && j < sChars.length && sChars[i] == sChars[j]) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
