You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].

The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.

For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
Return the maximum points you can earn for the exam.
    
class Solution {
    long dp[];
    private long dfs(int[][] questions, int i) {
        if (i >= questions.length) {
            return 0;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        long points = questions[i][0];
        int skip = questions[i][1];

        // dp[i] = max(skip it, solve it)
        dp[i] = Math.max(points + dfs(questions, i + skip + 1), dfs(questions, i + 1));
        return dp[i];
    }
    
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        dp = new long[n];
        
        return dfs(questions, 0);
    }
}
