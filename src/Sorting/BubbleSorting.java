package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSorting {

    public static List<Integer> bubbleSorting(ArrayList<Integer> dataList){

        for(int i = 0; i < dataList.size() - 1; i++){
            boolean sort = false;

            for(int j = 0; j < dataList.size() - 1 - i; j++){
                if(dataList.get(j) > dataList.get(j + 1)){
                    Collections.swap(dataList, j, j+1);
                    sort = true;
                }
            }

            if(sort == false) break;
        }

        return dataList;
    }

    public static void main(String[] args){
        List<Integer> arrayList = new ArrayList<>();

        for(int i = 0 ; i < 10 ; i++){
            arrayList.add((int)(Math.random() * 100));
        }

        bubbleSorting((ArrayList<Integer>) arrayList);

        System.out.println(arrayList);
    }
}
