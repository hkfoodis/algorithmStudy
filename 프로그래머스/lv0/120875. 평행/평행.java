import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        List<Float> leanList = new ArrayList<>();

        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                leanList.add((float)(dots[i][1] - dots[j][1]) 
                    / (float)(dots[i][0] - dots[j][0]));
            }
        }

        for (int i = 0; i < leanList.size() - 1; i++) {
            for (int j = i + 1; j < leanList.size(); j++) {
                float a = leanList.get(i);
                float b = leanList.get(j);
                if (a == b) {
                    return 1;
                }
            }
        }

        return 0;
    }
}