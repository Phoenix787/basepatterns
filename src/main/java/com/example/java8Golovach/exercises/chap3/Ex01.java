package com.example.java8Golovach.exercises.chap3;

import java.util.stream.Stream;

public class Ex01 {
    public static void main(String[] args) {

        System.out.println(addUp(Stream.of(1, 2, 3)));

    }

    public static int addUp(Stream<Integer> numbers) {
               return numbers.reduce(0, (x, y) -> x + y);
    }
}
