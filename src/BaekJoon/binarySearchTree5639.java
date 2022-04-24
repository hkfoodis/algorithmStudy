package BaekJoon;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class binarySearchTree5639 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer> a;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        a = new ArrayList<>();
        while (!(input = br.readLine()).equals("")) {
            a.add(Integer.parseInt(input));
        }
    }

    static void postOrder(int L, int R) {
        if (L > R) return;
        int mid = R;

        for (int i = L + 1; i <= R; i++) {
            if (a.get(i) > a.get(L)) {
                mid = i - 1;
                break;
            }
        }

        postOrder(L + 1, mid);
        postOrder(mid + 1, R);
        sb.append(a.get(L)).append('\n');
    }

    static void pro() {
        postOrder(0, a.size() - 1);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
