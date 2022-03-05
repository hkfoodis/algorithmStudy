package Greedy;

import java.util.Arrays;
import java.util.Comparator;

//무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
//        각 물건은 무게(w)와 가치(v)로 표현될 수 있음
//        물건은 쪼갤 수 있으므로 물건의 일부분이 배낭에 넣어질 수 있음, 그래서 Fractional Knapsack Problem 으로 부름
//        Fractional Knapsack Problem 의 반대로 물건을 쪼개서 넣을 수 없는 배낭 문제도 존재함 (0/1 Knapsack Problem 으로 부름)
// 물건1: 무게 = 10, 가중 = 10
// 물건2: 무게 = 15, 가중 = 12
// 물건3: 무게 = 20, 가중 = 10
// 물건4: 무게 = 25, 가중 = 8
// 물건5: 무게 = 30, 가중 = 5

public class FractionalKnapsackProblem {
    public static void knapsackFunc(Integer[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {        // 내림차순
                return (o2[1] / o2[0]) - (o1[1] / o1[0]);
            }
        });

        for (int i = 0; i < objectList.length; i++) {
            if (capacity > (double) objectList[i][0]) {
                capacity -= (double) objectList[i][0];
                totalValue += (double) objectList[i][1];
                System.out.println("무게:" + objectList[i][0] + ", 가치:" + objectList[i][1]);
            } else {
                fraction = capacity / (double)objectList[i][0];     // 물건을 얼마나 쪼개서 넣었는가
                totalValue += (double)objectList[i][1] * fraction;
                System.out.println("무게:" + objectList[i][0] + ", 가치:" + objectList[i][1] + ", 비율:" + fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치:" + totalValue);
    }

    public static void main(String[] args) {
        Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        knapsackFunc(objectList, 30.0);
    }
}
