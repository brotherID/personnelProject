package org.payment.bankCheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Reduce {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,3,4,5);
        Integer k = 6 ;
        System.out.println(foundPair(numbers,k));

    }

    public static List<Integer> foundPair(List<Integer> numbers,Integer k){
        for(Integer n : numbers){
            Integer b = k - n;
            if (numbers.contains(b)){
                return List.of(n,b);
            }
        }
        return null;
    }
}
