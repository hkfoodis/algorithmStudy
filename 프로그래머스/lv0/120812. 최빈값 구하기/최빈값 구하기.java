import java.util.*;
class Solution {
    public int solution(int[] array) {
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
}