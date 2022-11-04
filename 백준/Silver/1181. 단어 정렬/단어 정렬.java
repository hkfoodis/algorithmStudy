import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() != o2.length()) return o1.length() - o2.length();

            return o1.compareTo(o2);
        }
    }

    static void input() {
        N = scan.nextInt();
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = scan.next();
        }
    }

    static int N;
    static String[] words;

    static void pro() {
        Arrays.sort(words, new MyComparator());
        for (int i = 0; i < N; i++) {
            if (i == 0 || !words[i].equals(words[i - 1])){       // 단어 중복 출력 방지
                sb.append(words[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
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
