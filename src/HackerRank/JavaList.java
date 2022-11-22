package HackerRank;

import java.util.*;

public class JavaList {

    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, Q;
    static List<Integer> L = new ArrayList<>();

    static void input() {
        N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            L.add(scan.nextInt());
        }
        Q = scan.nextInt();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        input();

        for (int i = 0; i < Q; i++) {
            String command = scan.next();

            if (command.equals("Insert")) {
                int x = scan.nextInt();
                int y = scan.nextInt();

                L.add(x, y);

            } else {
                int x = scan.nextInt();

                L.remove(x);
            }
        }

        for (int i : L) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }
}
