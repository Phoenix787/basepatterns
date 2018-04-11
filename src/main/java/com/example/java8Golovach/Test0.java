package com.example.java8Golovach;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * пример с методом collect
 * нам нужно чтобы метод toString выводил не квадратные скобки,
 * а фигурные в начале и конце коллекции
 */
public class Test0 {
    public static void main(String[] args) {
        System.out.println(Arrays.asList(1, 2, 3).toString());

        System.out.println(toStr(Arrays.asList(1, 2, 3)));

        //пример использования локальной переменной в лямбда-выражении
//        String name = "User";
//        Button button = new Button();
//        button.addActionListener(e -> System.out.println("hi " + name));

        //Пример подсчета артистов из Лондона

        long count = new ArrayList<>(Arrays.asList(
                new Artist("Peter", "London"),
                new Artist("Grace", "NY"),
                new Artist("Van", "London"),
                new Artist("Groove", "London")))
                .stream()
                .filter(artist -> artist.isFrom("London")).count();

        System.out.println("Count of artist from London: " + count);




    }

    private static String toStr(List<Integer> list) {
        return list
                .stream()
                .map(String::valueOf)           //.map(e -> "" + e)
                .collect(Collectors.joining(", ", "{", "}"));
    }
}

class Artist{
    private String name;
    private String from;

    public Artist(String name, String from) {
        this.name = name;
        this.from = from;
    }

    public Boolean isFrom(String city) {
        return from.equalsIgnoreCase(city);
    }
}


