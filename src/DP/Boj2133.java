package DP;

import java.util.Scanner;

public class Boj2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        int answer = 0;
        if (N % 2 == 1) {
            answer = 0;
        } else {
            dp[0] = 1;
            dp[2] = 3;

            for (int i = 4; i <= N; i += 2) { // 짝수만 계산하면서 dp 배열 채우기
                dp[i] = dp[i - 2] * dp[2]; // dp[i]는 이전 단계의 결과를 이용하여 계산
                for (int j = i - 4; j >= 0; j -= 2) { // 이전 단계의 결과를 이용하여 dp[i] 계산
                    dp[i] += dp[j] * 2;
                }
            }
            answer = dp[N];
        }
        System.out.println(answer);
        sc.close();
    }
}