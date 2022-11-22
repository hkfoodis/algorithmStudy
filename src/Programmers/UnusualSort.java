package Programmers;

import java.util.*;
import java.util.stream.Collectors;

public class UnusualSort {

    public static int[] solution(int[] numlist, int n) {

        List<Integer> numList = Arrays.stream(numlist).boxed().collect(Collectors.toList());

        Collections.sort(numList, (o1, o2) -> {
            int dif1 = Math.abs(o1 - n);
            int dif2 = Math.abs(o2 - n);
            if (dif1 > dif2) return 1;
            else if (dif1 == dif2) {
                return o2 - o1;
            } else {
                return -1;
            }
        });

        return numList.stream().mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {
        int[] numlist = {1,2,3,4,5,6};
        int n = 4;

        System.out.println(Arrays.toString(solution(numlist, n)));
    }
}
