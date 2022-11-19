package Programmers;

public class KCounter {
    public static int solution(int i, int j, int k) {
        int answer = 0;

        for (int a = i; a <= j; a++) {
            String str = String.valueOf(a);
            for (int b = 0; b < str.length(); b++) {
                char ch = str.charAt(b);
                if (ch == k + '0') answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int i = 1, j = 13, k = 1;
        System.out.println(solution(i,j,k));
    }

}
