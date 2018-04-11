package com.example.java8Golovach.lesson5;
//groupingBy​(Function classifier)
//groupingBy​(Function classifier, Collector downstream)
//groupingBy​(Function classifier, Supplier mapFactory, Collector downstream)
//Группирует элементы по критерию, сохраняя результат в Map.
// Вместе с представленными выше агрегирующими коллекторами, позволяет гибко собирать данные.


//groupingByConcurrent​(Function classifier)
//groupingByConcurrent​(Function classifier, Collector downstream)
//groupingByConcurrent​(Function classifier, Supplier mapFactory, Collector downstream)
//Аналогичный набор методов, только сохраняет в ConcurrentMap.

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestGroupingBy {
    public static void main(String[] args) {
        Map<Integer, List<String>> map1 = Stream.of(
                "ab", "c", "def", "gh", "ijk", "l", "mnop")
                .collect(Collectors.groupingBy(String::length));
        map1.entrySet().forEach(System.out::println);

        Map<Integer, String> map2 = Stream.of(
                "ab", "c", "def", "gh", "ijk", "l", "mnop")
                .collect(Collectors.groupingBy(String::length,
                        Collectors.mapping(
                                String::toUpperCase,
                                Collectors.joining())));

        map2.entrySet().forEach(System.out::println);

        Map<Integer, List<String>> map3 = Stream.of(
                "ab", "c", "def", "gh", "ijk", "l", "mnop")
                .collect(Collectors.groupingBy(String::length,
                        LinkedHashMap::new,
                        Collectors.mapping(
                                String::toUpperCase,
                                Collectors.toList()
                        )));
        map3.entrySet().forEach(System.out::println);


    }
}
