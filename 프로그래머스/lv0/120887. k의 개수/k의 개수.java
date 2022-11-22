class Solution {
    public int solution(int i, int j, int k) {
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
}