package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Printer {

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

    public static int solution(int[] priorities, int location) {
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

    public static void main(String[] args) {
        int[] priorities = {2,1,3,2};
        int location = 2;
        System.out.println(solution(priorities, location));
    }
}
