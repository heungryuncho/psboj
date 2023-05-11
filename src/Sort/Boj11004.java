package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11004 {
    static int K, N;

    // 퀵 정렬에 사용하는 파티션 함수
    public static int partition(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        swap(array, left, mid); // 중앙값을 첫 번째 요소로 이동

        int pivot = array[left]; // 피벗을 첫번째 원소로 지정
        int i = left, j = right;

        while (i < j) {
            while (pivot < array[j]) {// 피벗보다 작거나 같은 값을 오른쪽에서 부터 찾음
                j--;
            }

            while (i < j && pivot >= array[i]) { // 피벗보다 큰 값을 왼쪽에서부터 찾음
                i++;
            }
            swap(array, i, j); // 찾은 i와 j를 교환
        }
        // 반복문을 빠져나왔을 때 i와 j가 만나면
        // i와 피벗을 교환하고 i를 반환
        array[left] = array[i];
        array[i] = pivot;
        return i;
    }

    // 배열에서 두 원소의 위치를 교환하는 함수
    public static void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    // 퀵 정렬 함수
    public static void quicksort(int[] array, int left, int right) {
        if (left >= right) { // 정렬할 배열의 크기가 1 이하이면 종료
            return;
        }
        int pi = partition(array, left, right); // 파티션 함수를 호출하여 피벗의 위치를 반환받음

        // pi+1의 값과 K를 비교하여 적절한 부분 배열을 선택하여 재귀적으로 호출함
        if (pi + 1 == K) {// pi+1이 K와 가틍면 선택한 부분 배열에서 K번째로 작은 수를 찾은 것이므로 종료
            return;
        } else if (pi + 1 < K) { // pi+1이 K보다 작으면 선택한 부분 배열의 오른쪽 부분 배열에서 K번째로 작은 수를 찾기 위해 재귀호출
            quicksort(array, pi + 1, right);
        } else { // pi+1이 K보다 크면 선택한 부분 배열의 왼쪽 부분 배열에서 K번째로 작은 수를 찾기 위해 재귀호출
            quicksort(array, left, pi - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quicksort(arr, 0, N - 1);

        System.out.println(arr[K - 1]);
    }

    }