package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);
    private String resultString (Integer element){
           if (element <= 26) {
                int ASCIICode = element + 96;
                return String.valueOf((char) ASCIICode);
            } else if (element%26!=0){
                int ASCIICode1 = (int) Math.floor(element / 26) + 96;
                int ASCIICode2 = element % 26 + 96;
                String string1 = String.valueOf((char) ASCIICode1);
                String string2 = String.valueOf((char) ASCIICode2);
                return string1.concat(string2);
            }else {
               int ASCIICode1 = (int) Math.floor(element / 26) + 96-1;
               int ASCIICode2 = 26+96;/*当对应字符应该是"az","bz"等等时*/
               String string1 = String.valueOf((char) ASCIICode1);
               String string2 = String.valueOf((char) ASCIICode2);
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
        for (Integer element : array){
            resultStrings.add(resultString(element));
        }
        /*return  resultStrings;*/
        return array.stream().map(elem->letters[elem-1]).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        List<String> resultStrings=new ArrayList<>();
        for (Integer element : array){
            resultStrings.add(resultString(element));
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
