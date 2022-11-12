import java.util.*;
class Solution {
    static class Pair {
        private int index;
        private int priority;

        public Pair(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        public int getIndex() {
            return index;
        }

        public int getPriority() {
            return priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Pair(i, priorities[i]));
        }

        while (!q.isEmpty()) {
            int priority = q.peek().getPriority();
            boolean flag = true;

            for (Pair pair : q) {
                if (pair.getPriority() > priority) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer++;
                Pair temp = q.poll();
                if (temp.getIndex() == location) {
                    return answer;
                }
            } else {
                Pair temp = q.poll();
                q.add(temp);
            }
        }

        return -1;
    }
}