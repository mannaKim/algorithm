class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0]; // 첫 번째 값을 기준으로 최소공배수 계산 시작
        for (int i = 1; i < arr.length; i++) {
            lcm = getLCM(lcm, arr[i]); // 현재 lcm과 다음 값을 기준으로 최소공배수 계산
        }
        return lcm;
    }
    // 유클리드 호제법을 통한 최대공약수 구하기
    // A를 B로 나눈 몫을 q, 나머지를 r 이라고 할때 GCD(A,B) = GCD(B,r) 이다.
    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) return num2;
        return getGCD(num2, num1 % num2);
    }
    // 최소공배수 구하기
    // LCM(a,b) = (a*b) / GCD(a,b)
    public static int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }
}