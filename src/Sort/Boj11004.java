package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11004 {
    static int K, N;

    public static void quickSort(int[] array, int left, int right) {
        // 정렬 대상이 하나 이하인 경우, 정렬하지 않고 함수 종료
        if (left >= right) {
            return;
        }

        int pi = partition(array, left, right);

        // k번째 수가 속한 영역을 재귀 호출을 통해 정렬
        if (pi + 1 == K) {
            return;
        } else if (pi + 1 < K) {
            quickSort(array, pi +1, right);
        } else {
            quickSort(array, left, pi - 1);
        }
    }

    public static int partition(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        swap(array, left, mid); // 중앙값을 첫번째 요소로 이동

        int pivot = array[left];
        int i = left, j = right;

        // i, j가 만날 때까지 반복
        while (i < j) {
            // j는 오른쪽에서 왼쪽으로 피봇보다 작거나 같은 값을 찾는다.
            while (pivot < array[j]) {
                j--;
            }
            // i는 왼쪽에서 오른쪽으로 피봇보다 큰 값을 찾는다.
            while (i < j && pivot >= array[i]) {
                i++;
            }
            swap(array, i, j);
        }
        // 반복문을 벗어난 경우는 i와 j가 만난 경우
        // 피봇과 교환
        array[left] = array[i];
        array[i] = pivot;

        // 구분점 반환
        return i;
    }

    public static void swap(int[] array, int a, int b) {
        int tmp = array[b];
        array[b] = array[a];
        array[a] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, N - 1);
        System.out.println(arr[K - 1]);
    }

}