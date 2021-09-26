package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        return Arrays.stream(array)/*将array放入流中*/
                .flatMap(x -> Arrays.stream(x)/*将array的每个数组的元素放入流中*/)
                /*flatMap表示将每个元素合取出，放进一个大的List中*/
                .collect(Collectors.toList());
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        return Arrays.stream(array).flatMap(x -> Arrays.stream(x)).distinct().collect(Collectors.toList());
    }
}
