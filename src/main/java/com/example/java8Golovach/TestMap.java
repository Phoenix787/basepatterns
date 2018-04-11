package com.example.java8Golovach;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * map
 * Если имеется функция, которая преобразует значение из одного типа в дру-
 * гой, то метод map позволит применить ее к потоку значений и тем самым по-
 * родить поток новых значений.
 */
public class TestMap {
    public static void main(String[] args) {
        List<String> collected = new ArrayList<>();
        for (String string : asList("a", "b", "hello")){
            String uppercaseString = string.toUpperCase();
            collected.add(uppercaseString);
        }

        assertEquals(asList("A", "B", "HELLO"), collected);

        //тоже самое с помощью потокового API
        List<String> collected1 = Stream.of("a", "b", "hello")
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertEquals(asList("A", "B", "HELLO"), collected1);
    }
}
