package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if(leftBorder > rightBorder){
            int num = leftBorder;
            leftBorder = rightBorder;
            rightBorder = num;
        }
        int even=0;
        for (int i=leftBorder;i<=rightBorder;i++){
            if (0==i%2)even+=i;
        }
        return even;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {

        if(leftBorder > rightBorder){
            int num = leftBorder;
            leftBorder = rightBorder;
            rightBorder = num;
        }
        int odd=0;
        for (int i=leftBorder;i<=rightBorder;i++){
            if (0!=i%2)odd+=i;
        }
        return odd;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(x -> x * 3 + 2)/*将每个元素都转换为int类型*/
                .sum()/*将流中的OptionalDouble对象容器里面的值的总和*/;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) % 2 == 1){
                arrayList.set(i,arrayList.get(i) * 3 + 2);
            }
        }
        return  arrayList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(m -> m % 2 == 1).mapToInt(x -> x * 3 + 5).sum();
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> ElementsAdd = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            ElementsAdd.add((arrayList.get(i) + arrayList.get(i + 1))*3);
        }
        return  ElementsAdd;
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(m -> m % 2 == 0).mapToInt(x -> x).sum()/ 2.0;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(m -> m % 2 == 0).mapToInt(x -> x)
                .average()/*返回描述此流元素算术平均值的OptionalDouble*/
                .getAsDouble()/*返回此OptionalDouble描述的值*/;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(m -> m % 2 == 0)
                .anyMatch(m -> m == specialElment)/*判断的条件里，任意一个元素符合条件，就返回 true 值*/;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(m -> m % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> ArrlistSort =  arrayList.stream().filter(m -> m % 2 == 0).sorted().collect(Collectors.toList());
        ArrlistSort.addAll(arrayList.stream().filter(m -> m % 2 == 1).sorted(Comparator.reverseOrder()/*降序*/).collect(Collectors.toList()));
        return ArrlistSort;
    }

}
