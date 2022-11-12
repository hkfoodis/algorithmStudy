import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();

        /* 장르별 재생 수 계산 */
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        /* 재생 수 별 장르 정렬 */
        List<String> genreList = new ArrayList<>(map.keySet());
        Collections.sort(genreList, (o1, o2) -> map.get(o2) - map.get(o1));

        /* 장르별로 상위 두 곡 인덱스 번호 가져오기 */
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < genreList.size(); i++) {
            String genre = genreList.get(i);

            int max = 0;
            int firstIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                if (genre.equals(genres[j]) && max < plays[j]) {
                    max = plays[j];
                    firstIdx = j;
                }
            }

            max = 0;
            int secondIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                if (genre.equals(genres[j]) && max < plays[j] && j != firstIdx) {
                    max = plays[j];
                    secondIdx = j;
                }
            }

            result.add(firstIdx);
            if (secondIdx > -1) result.add(secondIdx);

        }


        return result.stream().mapToInt(o -> o).toArray();
    }
}