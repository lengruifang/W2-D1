package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> result = new ArrayList<>();
        if(left < right){
            for (int i = left; i <= right; i++) {
                result.add(i);
            }
        } else{
            for (int i = left; i >= right; i--) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return    getListByInterval(left, right).stream().filter(m -> m % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return   Arrays.stream(array).boxed()/*将值装箱为Double类型*/.filter(m -> m % 2 == 0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> secondArraylist = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        return   Arrays.stream(firstArray).boxed().filter(m -> secondArraylist.contains(m)).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {

        List<Integer> firstArraylist = Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> secondArraylist = Arrays.stream(secondArray).collect(Collectors.toList());
        firstArraylist.addAll(secondArraylist);

        return firstArraylist.stream().distinct()/*去重*/.collect(Collectors.toList());
    }
}
