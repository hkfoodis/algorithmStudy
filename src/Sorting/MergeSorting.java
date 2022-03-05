package Sorting;

import java.util.ArrayList;

public class MergeSorting {

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        int leftPoint = 0;
        int rightPoint = 0;

        // CASE1: left/right 둘 다 있을 때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint += 1;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint += 1;
            }
        }

        // CASE2: right 데이터가 없을 때
        while (leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint += 1;
        }

        // CASE3: left 데이터가 없을 때
        while (rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint += 1;
        }

        return mergedList;
    }

    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        leftArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));     // 최종적으로 정렬된 절반의 배열이 들어감
        rightArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));  // 최종적으로 정렬된 절반의 배열이 들어가는 형식

        return this.mergeFunc(leftArr, rightArr);
    }

    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0 ; i < 6 ; i++){
            arrayList.add((int)(Math.random() * 100));
        }

        MergeSorting mergeSorting = new MergeSorting();

        ArrayList<Integer> result = new ArrayList<>();
        result = mergeSorting.mergeSplitFunc(arrayList);

        System.out.println(result);
    }
}
