package 입출력;

import java.util.Scanner;

public class Boj8393 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int sum = 0;
        for(int i = 1; i<=N; i++){
            sum += i;
        }
        System.out.println(sum);
    }
}