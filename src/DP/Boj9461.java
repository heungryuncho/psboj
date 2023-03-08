package DP;

import java.util.Scanner;

public class Boj9461 {
    public static Long[] seq = new Long[101];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        seq[0] = 0L;
        seq[1] = 1L;
        seq[2] = 1L;
        seq[3] = 1L;

        while (T-- > 0) {
            int N = sc.nextInt();
            System.out.println(padovan(N));
        }

    }

    public static long padovan(int N) {
        if (seq[N] == null) {
            seq[N] = padovan(N - 2) + padovan(N - 3);
        }
        return seq[N];
    }
}