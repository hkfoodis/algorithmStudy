package Sorting;

import java.util.ArrayList;

public class QuckSorting {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList){

        if(dataList.size() <= 1){
            return dataList;
        } else {
            Integer pivot = dataList.get(0);

            ArrayList<Integer> leftArr = new ArrayList<>();
            ArrayList<Integer> rightArr = new ArrayList<>();

            for(int i=1; i<dataList.size(); i++){
                if(dataList.get(i) > pivot){
                    rightArr.add(dataList.get(i));
                } else {
                    leftArr.add(dataList.get(i));
                }
            }

            ArrayList<Integer> mergedList = new ArrayList<>();
            mergedList.addAll(this.sort(leftArr));
            mergedList.add(pivot);
            mergedList.addAll(this.sort(rightArr));

            return mergedList;

        }

    }

    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0 ; i < 6 ; i++){
            arrayList.add((int)(Math.random() * 100));
        }

        QuckSorting quickSort = new QuckSorting();
        ArrayList<Integer> result = new ArrayList<>();
        result = quickSort.sort(arrayList);

        System.out.println(result);
    }
}
