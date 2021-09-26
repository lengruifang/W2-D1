package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String resultString (Integer elemet){
        if (elemet<=26) {
            int ASCIICode = elemet + 96;
            return String.valueOf((char) ASCIICode);
        }else {
            int ASCIICode1= (int) Math.floor(elemet/26)+96;
            int ASCIICode2=elemet%26+96;
            String string1=String.valueOf((char) ASCIICode1);
            String string2=String.valueOf((char) ASCIICode2);
            return string1.concat(string2);
        }
    }

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(x -> x * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        List<String> resultStrings=new ArrayList<>();
        for (Integer elemet : array){
            resultStrings.add(resultString(elemet));
        }
        return  resultStrings;
    }

    public List<String> mapLetters() {
        List<String> resultStrings=new ArrayList<>();
        for (Integer elemet : array){
            resultStrings.add(resultString(elemet));
        }
        return  resultStrings;
    }

    public List<Integer> sortFromBig() {
        return  array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return  array.stream().sorted().collect(Collectors.toList());
    }
}
