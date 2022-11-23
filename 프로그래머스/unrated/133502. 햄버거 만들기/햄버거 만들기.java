import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int a : ingredient) {

            if (a == 1) {
                stack.add(a);

                if (stack.size() < 4) continue;

                int bread1 = stack.pop();
                int meat = stack.pop();
                int vegetable = stack.pop();
                int bread2 = stack.pop();

                if (meat != 3 || vegetable != 2 || bread2 != 1) {
                    stack.add(bread2);
                    stack.add(vegetable);
                    stack.add(meat);
                    stack.add(bread1);
                } else {
                    answer++;
                }

            } else {

                stack.add(a);

            }
        }

        return answer;
    }
}