package DP;

import java.util.Scanner;

public class Boj11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1]; // 입력받은 수열 저장할 배열
        int[] d = new int[N + 1]; // 각 원소를 마지막에 사용한 가장 긴 감소하는 부분 수열의 길이 저장할 배열

        // 수열 입력받기
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        d[1] = 1; // 첫 번째 원소는 길이가 1인 감소하는 부분 수열에 속함

        // 각 원소를 마지막에 사용한 가장 긴 감소하는 부분 수열의 길이 구하기
        for (int i = 2; i <= N; i++) {
            d[i] = 1; // 초기값으로 자기 자신만으로 길이가 1인 감소하는 부분 수열을 만들 수 있음
            for (int j = 0; j < i; j++) {
                // arr[j]가 arr[i]보다 크고, d[j]가 d[i]보다 크거나 같으면
                // j번째 원소를 마지막에 사용하는 감소하는 부분 수열에 i번째 원소를 추가하여 새로운 감소하는 부분 수열을 만들 수 있음
                if (arr[i] < arr[j] && d[i] <= d[j]) {
                    d[i] = d[j] + 1;
                }
                // arr[i]와 arr[j]가 같으면
                // j번째 원소를 마지막에 사용하는 감소하는 부분 수열에 i번째 원소를 추가하거나 추가하지 않더라도
                // i번째 원소를 마지막에 사용하는 감소하는 부분 수열의 길이는 j번째 원소를 마지막으로 사용하는 감소하는 부분 수열의 길이와 같음
                else if (arr[i] == arr[j]) {
                    d[i] = d[j];
                }
            }
        }

        int max = 0; // 가장 긴 감소하는 부분 수열의 길이를 저장할 변수

        // d배열에서 가장 큰 값을 찾아 max 변수에 저장
        for (int i = 1; i <= N; i++) {
            max = Math.max(d[i], max);
        }
        System.out.println(max);
        sc.close();
    }
}
