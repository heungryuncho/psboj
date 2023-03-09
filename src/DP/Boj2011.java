package DP;

import java.util.Scanner;

public class Boj2011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        // 만약 문자열의 첫 번째 문자가 0이라면 잘못된 암호
        if (s.charAt(0) == '0'){
            System.out.println("0");
            return;
        }

        long[] dp = new long[s.length() + 1];
        dp[0] = dp[1] = 1;

        // 문자열의 길이만큼 반복하며 dp 배열 갱신
        for (int i = 2; i <= s.length(); i++) {
            char ch = s.charAt(i-1); // 현재 체크하는 문자
            char prev = s.charAt(i-2); // 앞 문자

            // 현재 문자가 0인 경우
            if (ch == '0') {
                // 앞 문자가 1 또는 2인 경우에만 앞 문자와 결합하여 암호코드 가능
                if (prev == '1' || prev == '2') {
                    dp[i] = dp[i-2] % 1000000;
                } else {
                    // 암호코드가 잘못된 경우이므로 종료
                    break;
                }
            }

            // 현재 문자가 0이 아닌 경우
            else {
                // 앞 문자가 0인 경우
                if (prev == '0') {
                    // 앞 문자와 결합할 수 없으므로 경우의 수 변화 없음
                    dp[i] = dp[i-1] % 1000000;
                }
                // 앞 문자가 0이 아닌 경우
                else {
                    // 앞 문자와 현재 문자를 결합하여 만들 수 있는 숫자 체크
                    int temp = (prev - '0') * 10 + (ch - '0');
                    // 만들 수 있는 숫자가 1~26 범위 내에 있다면
                    if (1 <= temp && temp <= 26) {
                        // 앞 문자와 현재 문자를 결합한 경우와 결합하지 않은 경우 모두 고려하여 dp 배열 갱신
                        dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000;
                    }
                    // 만들 수 있는 숫자가 범위 내에 없다면
                    else {
                        // 앞 문자와 현재 문자를 결합할 수 없으므로 경우의 수 변화 없음
                        dp[i] = dp[i-1] % 1000000;
                    }
                }
            }
        }
        System.out.println(dp[s.length()] % 1000000);

    }

}