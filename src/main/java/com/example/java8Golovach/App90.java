package com.example.java8Golovach;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class App90 {
    public static void main(String[] args) {
        partition(new ArrayList<>(asList(1,2,3,4,5,6,7,8,9))).stream()
                .flatMap(arg -> partition(arg).stream())
                .filter(lists -> eval(lists) == 100)
                .map(App90::toStr)
                .forEach(System.out::println);
    }

    private static String toStr(List<List<List<Integer>>> arg) {
        return null;
    }

    private static Integer eval(List<List<List<Integer>>> lists) {
        return null;
    }

    public static <T> List<List<List<T>>> partition(List<T> arg){
        return null;
    }

    public static <T> List<List<T>> copy(List<T> arg){
        return null;
    }
}
