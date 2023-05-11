//package DataStructure;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Boj10828 {
//
//    public static int[] stack;
//    public static int size = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//
//        stack = new int[N];
//
//        while (N-- > 0) {
//            st = new StringTokenizer(br.readLine(), " ");
//
//            switch (st.nextToken()) {
//                case "push":
//                    push(Integer.parseInt(st.nextToken()));
//                    break;
//                case "pop":
//                    sb.append(pop()).append('\n');
//                    break;
//                case "size":
//                    sb.append(size()).append('\n');
//                    break;
//                case "empty":
//                    sb.append(empty()).append('\n');
//                    break;
//                case "top":
//                    sb.append(top()).append('\n');
//                    break;
//            }
//        }
//        System.out.println(sb);
//
//    }
//
//    public static void push(int item) {
//        stack[size] = item;
//        size++;
//    }
//}
