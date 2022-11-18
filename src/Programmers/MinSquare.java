package Programmers;

import java.util.*;

public class MinSquare {
    public static int solution(int[][] sizes) {
        int answer = 0;

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        for (int[] a : sizes) {
            arr1.add(Math.max(a[0], a[1]));
            arr2.add(Math.min(a[0], a[1]));
        }

        Collections.sort(arr1);
        Collections.sort(arr2);

        answer = arr1.get(arr1.size() - 1) * arr2.get(arr2.size() - 1);

        return answer;
    }

    public static void main(String[] args) {
        int[][] sizes = {{60,50},{30,70},{60,30},{80,40}};
        System.out.println(solution(sizes));
    }
}
