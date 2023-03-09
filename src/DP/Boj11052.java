package DP;

import java.util.Scanner;

public class Boj11052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] d = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        // 카드 n개를 사는 경우 최대 가격 구하기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                // 카드 j개를 사는 가격 + 카드 (i-j)개를 사는 경우 최대 가격
                d[i] = Math.max(d[i], d[i - j] + arr[j]);
            }
        }
        System.out.println(d[N]);
        sc.close();
    }
}
