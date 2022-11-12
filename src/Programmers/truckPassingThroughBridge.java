package Programmers;

import java.util.*;

public class truckPassingThroughBridge {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum = 0;

        Queue<Integer> bridge = new LinkedList<>();

        /* 다리를 큐로 설정하고 큐의 size는 bridge_length가 넘어가지 않도록 truck_weights에서 하나씩 가져올 때마다 weight를 넘는지 확인 */
        /* 트럭 한 대가 다리를 지나가려면 걸리는 시간은 bridge_length 만큼 걸린다. */

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];
            while (true) {
                /* 아무 트럭도 다리 위에 없는 경우 */
                if (bridge.isEmpty()) {
                    bridge.add(truck);
                    sum += truck;
                    time++;
                    break;

                    /* 다리 위에 트럭이 꽉 찬 경우 */
                } else if (bridge.size() == bridge_length) {
                    sum -= bridge.poll();

                    /* 다리위에 트럭이 꽉 차있지 않은 경우 */
                } else {
                    /* 다리 위에 트럭을 올릴 수 있는지 판별 */
                    if (sum + truck <= weight) {
                        bridge.add(truck);
                        sum += truck;
                        time++;
                        break;
                        /* 트럭을 올릴 수 없는 경우 */
                    } else {
                        /* 넘는 경우 0을 넣어서 큐에 있는 트럭이 다리를 건너도록 해준다. */
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }

        /* 마지막에 다리에 넣어줄 때는 바로 break 되므로 다리 길이만큼 시간을 더해준다. */
        return time + bridge_length;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}
