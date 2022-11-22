package Programmers;

import java.util.*;

public class Factorization {

    public static int[] solution(int n) {

        Set<Integer> set = new HashSet<>();

        while (n != 1) {

            for (int i = 2; i < 10000000; i++) {
                if (n % i == 0) {
                    n /= i;
                    set.add(i);
                    break;
                }
            }
        }

        List<Integer> answer = new ArrayList<>(set);

        Collections.sort(answer);

        return answer.stream().mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {
        int n = 17;

        System.out.println(Arrays.toString(solution(n)));
    }
}
