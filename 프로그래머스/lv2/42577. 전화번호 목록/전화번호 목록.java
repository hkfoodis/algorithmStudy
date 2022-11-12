import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        //* 하나의 번호가 다른 번호의 앞에 배치되어있으면 접두어가 있다고 본다. */
        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) return false;
        }

        return true;
    }
}