package com.example.java8Golovach.lesson5;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * нужно собрать лишь уникальные элементы в список
 */
public class Test01 {
    public static void main(String[] args) {
        ArrayList<Integer> collect = Stream.of(1, 2, 3, 1, 9, 2, 5, 3, 4, 8, 2)
                .collect(Collectors
                        .collectingAndThen(Collectors.toCollection(LinkedHashSet::new), ArrayList::new));

        for (Integer integer : collect) {
            System.out.printf("%d ", integer);
        }
    }
}
