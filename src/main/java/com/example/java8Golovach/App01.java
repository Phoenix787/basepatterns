package com.example.java8Golovach;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;


public class App01 {
    public static void main(String[] args) {

        List<String> arg0 = asList("1", "2", "3");
        List<String> arg1 = asList("A", "B");

        for (List<String> elem : mul(arg0, arg1)) {
            System.out.println(elem);
        }
    }

    public static <T> List<List<T>> mul(List<T> arg0, List<T> arg1) {
        List<List<T>> result = new ArrayList<>();
        for (T fst : arg0) {
            for (T snd : arg1) {
                result.add(asList(fst, snd));
            }
        }
        return result;
    }
}


