package com.example.java8Golovach;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Метод flatMap позволяет заменить значение объектом Stream и кон-
 * катенировать все потоки.
 * Имеется объект Stream, содержащий
 * несколько списков чисел, и мы хотим получить все числа из всех
 * списков.
 */

public class TestFlatMap {
    public static void main(String[] args) {
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(num->num.stream())
                .collect(Collectors.toList());

        assertEquals(asList(1, 2, 3, 4), together);
    }
}
