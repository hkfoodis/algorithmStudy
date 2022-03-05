package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSorting {

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> dataList){

        for(int i = 0; i < dataList.size() - 1; i++){
            int lowest = i;

            for(int j = i + 1; j < dataList.size() - 1; j++){
                if(dataList.get(lowest) > dataList.get(j)){
                    lowest = j;
                }
            }
            Collections.swap(dataList, lowest, i);
        }

        return dataList;
    }

    public static void main(String[] args){
        List<Integer> arrayList = new ArrayList<>();

        for(int i = 0 ; i < 10 ; i++){
            arrayList.add((int)(Math.random() * 100));
        }

        selectionSort((ArrayList<Integer>) arrayList);

        System.out.println(arrayList);
    }
}
