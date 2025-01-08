class Solution {
    public static long[] memo;
    public long solution(int n) {
        long answer = 0;
        memo = new long[n+1];
        answer = dp(n);
        return answer;
    }
    public static long dp(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }

        if (n == 1) {
            memo[n] = 1;
            return memo[n];
        }
        if (n == 2) {
            memo[n] = 2;
            return memo[n];
        }
        if (n == 3) {
            memo[n] = 3;
            return memo[n];
        }
        
        memo[n] = ((dp(n-1)%1234567) + (dp(n-2)%1234567)) % 1234567;
        return memo[n];
    }
}