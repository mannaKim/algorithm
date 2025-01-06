class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while (true) {
            answer ++;
            int winA = (a+1) / 2;
            int winB = (b+1) / 2;
            if (winA == winB) {
                break;
            }
            a = winA;
            b = winB;
        }

        return answer;
    }
}