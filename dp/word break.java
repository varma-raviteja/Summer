
class Solution {
    private Map<String, Boolean> dp;

    public boolean solve(String s, Set<String> m) {
        if (s.length() == 0) {
            return true;
        }
        if (dp.containsKey(s))
            return dp.get(s);
        for (int i = 0; i < s.length(); i++) {
            String r = s.substring(0, i + 1);
            if (m.contains(r)) {
                if (solve(s.substring(i + 1), m)){
                    dp.put(s,true);
                    return true;
                }
            }
        }
        dp.put(s, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> m = new HashSet<>(wordDict);
        dp = new HashMap<>();
        return solve(s, m);
    }
}

class Solution {
    private String s;
    private List<String> wordDict;
    private int[] memo;
    
    private boolean dp(int i) {
        if (i < 0) return true;
        
        if (memo[i] != -1) {
            return memo[i] == 1;
        }
        
        for (String word: wordDict) {
            // Handle out of bounds case
            if (i - word.length() + 1 < 0) {
                continue;
            }
            
            if (s.substring(i - word.length() + 1, i + 1).equals(word) && dp(i - word.length())) {
                memo[i] = 1;
                return true;
            }
        }
        
        memo[i] = 0;
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        this.memo = new int[s.length()];
        Arrays.fill(this.memo, -1);
        return dp(s.length() - 1);
    }
}


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                if (i - word.length() >= 0 && dp[i - word.length()] && s.substring(i - word.length(), i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];        
    }
}
