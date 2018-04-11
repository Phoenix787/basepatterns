package com.example.java8Golovach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * декартово умножение java8
 */

public class App01z {
    public static void main(String[] args) {

        List<String> arg0 = asList("1", "2", "3");
        List<String> arg1 = asList("A", "B");
        mul(arg0, arg1).forEach(System.out::println);
    }

    private static <T> Stream<List<T>> mul(List<T> arg0, List<T> arg1) {
        return arg0.stream().flatMap(fst->arg1.stream().map(snd-> Arrays.asList(fst, snd)));

        //Stream<T> stream = arg1.stream();
        //return arg0.stream().flatMap(fst -> stream.map(snd-> Arrays.asList(fst, snd)));
    }
}


