package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.naming.NoInitialContextException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
this.arrayList=arrayList;
    }

    public int getMaximum() {
        return Collections.max(arrayList);
    }

    public double getMinimum() {
        return arrayList.stream().filter(e -> e != null).min((x,y)->x-y).orElse(null);
        /*orElse()
        当optional值不存在时，调用orElse()返回orElse()的参数，如果optional的值存在时返回optional的值
        orElseGet()
        当optional值不存在时，调用orElseGet()中接口调用的返回值，如果optional的值存在时返回optional的值*/
    }

    public double getAverage() {
        return arrayList.stream().mapToInt(x->x).average().getAsDouble();
    }

    public double getOrderedMedian() {
    Collections.sort(arrayList);
    if (arrayList.size()%2==0){
        return (double) (arrayList.get(arrayList.size()/2)+arrayList.get(arrayList.size()/2-1))/2;
    }else {
        return arrayList.get(arrayList.size()/2);
    }
    }

    public int getFirstEven() {
        return arrayList.stream().filter(num -> num % 2 == 0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        int firstEven = arrayList.stream().filter(num -> num % 2 == 0).findFirst().get();
        return arrayList.indexOf(firstEven);
    }

    public boolean isEqual(List<Integer> arrayList) {
        return arrayList.containsAll(this.arrayList) && this.arrayList.containsAll(arrayList);
//因为在测试方法中Reduce reduce = new Reduce(arrayList)是把arrayList放进去了，所以&&前面的实际是表示arrayList
        //跟arrayList作比较，后面的则是arrayList跟differentArray作比较。this.arrayList是arrayList。
    }
    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink<Integer> singleLink) {
        if (arrayList.size()%2==0){
            return (double) (arrayList.get(arrayList.size()/2)+arrayList.get(arrayList.size()/2-1))/2;
        }else {
            return (double) arrayList.get(arrayList.size()/2);
        }
    }

    public int getLastOdd() {
        List<Integer> oddList = arrayList.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
        return oddList.get(oddList.size() - 1);
    }

    public int getIndexOfLastOdd() {
        int num = getLastOdd();
        return arrayList.indexOf(num);
    }
}
