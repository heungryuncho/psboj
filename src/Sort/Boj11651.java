package Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Boj11651 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][1] = sc.nextInt();
            arr[i][0] = sc.nextInt();
        }

        // 먼저 x 좌표로 정렬한 다음 y 좌표로 정렬
        Arrays.sort(arr, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i][1] + " " + arr[i][0]);
        }
    }
}