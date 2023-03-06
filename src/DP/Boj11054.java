package DP;

import java.util.Scanner;

public class Boj11054 {
    static int N;
    static int[] r_dp;
    static int[] l_dp;
    static int[] seq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        r_dp = new int[N]; // LIS
        l_dp = new int[N]; // LDS
        seq = new int[N];

        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }

        LIS();
        LDS();

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < r_dp[i] + l_dp[i]) {
                max = r_dp[i] + l_dp[i];
            }
        }
        System.out.println(max - 1);
    }

    static void LIS() {
        for (int i = 0; i < N; i++) {
            r_dp[i] = 1;
            // 0 ~ i 이전 원소들 탐색
            for (int j = 0; j < i; j++) {
                // j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
                if (seq[j] < seq[i] && r_dp[i] < r_dp[j] + 1) {
                    r_dp[i] = r_dp[j] + 1; // j번째 원소의 +1 값이 i번째 dp가 된다.
                }
            }
        }
    }

    static void LDS(){
        for (int i = N - 1; i >= 0; i--) {
            l_dp[i] = 1;
            // 맨 뒤에서 i 이전 원소들을 탐색
            for (int j = N - 1; j > i; j--) {
                // i번째 원소가 j번째 원소보다 크면서 i번째 dp가 j번째 dp+1 값보다 작은경우
                if (seq[j] < seq[i] && l_dp[i] < l_dp[j] + 1) {
                    l_dp[i] = l_dp[j]+1; // j번째 원소의 +1이 i번째 dp값이 됨
                }
            }
        }
    }
}
