package Sort;

import java.util.HashMap;
import java.util.Scanner;

public class Boj11652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long tmp = sc.nextLong();
            // 이미 있는 카드 값이 들어모녀 원래 값에서 +1
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        // HashMap에서 가장 큰 값을 가진 Index 리턴
        int max = Integer.MIN_VALUE;
        long answer = 0;
        for (long x : map.keySet()) {
            if (map.get(x) > max) {
                max = map.get(x);
                answer = x;
            } else if (map.get(x) == max) {
                answer = Math.min(answer, x);
            }
        }
        System.out.println(answer);
        sc.close();
    }


}