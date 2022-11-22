package Programmers;

import java.util.*;

public class FindMaximumFrequency {

    public static int solution(int[] array) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        for (Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }

        List<Integer> answerList = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (max == map.get(key)) {
                answerList.add(key);
            }
        }

        if (answerList.size() > 1) return -1;
        return answerList.get(0);
    }

    public static void main(String[] args) {
        int[] array = {1,1,3,3};
        System.out.println(solution(array));
    }
}
