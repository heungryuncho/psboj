package DP;

import java.util.Scanner;

public class Boj2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int[][] dp = new int[201][201];

        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
            }
        }
        System.out.println(dp[T][N]);
    }
}
