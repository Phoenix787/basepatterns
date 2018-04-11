package com.example.java8Golovach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * collect(toList()) – энергичная операция, порождающая список из значений
 * в объекте Stream. Значения в Stream, над которыми выполняется операция, – это ре-
 * зультат применения к исходным значениям рецепта, сконструиро-
 * ванного последовательностью предыдущих вызовов методов объекта
 * Stream.
 */
public class TestCollectToList {
    public static void main(String[] args) {
        List<String> collected = Stream.of("a", "b", "c")
                .collect(Collectors.toList());

    }
}
