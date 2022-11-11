import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> q = new ArrayList<>();
        int value = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != value) {
                q.add(arr[i]);
                value = arr[i];
            }
        }

        return q.stream().mapToInt(o -> o).toArray();
    }
}