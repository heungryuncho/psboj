package Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Boj11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        // x좌표를 기준으로 오름차순으로 좌표를 정렬합니다.
        // x좌표가 같으면 y좌표를 기준으로 오름차순으로 정렬합니다.
        Arrays.sort(arr, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }

    }

}