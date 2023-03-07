package DP;

import java.util.Scanner;

public class Boj1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[100001];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = i; // 처음에는 1의 제곱으로만 표현 할 수 있는 개수로 초기화
            for (int j = 1; j * j <= i; j++) {
                // j*j를 뺀 수 i-j*j를 1의 제곱으로 표현하는 개수 (dp[i-j*j])에 1을 더한 값과
                // dp[i]를 비교하여 더 작은 값을 dp[i]에 저장한다.
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[N]);
        sc.close();
    }
}
