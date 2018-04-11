package com.example.java8Golovach.exercises.chap6;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * все элементы списка перемножаются, а резуль-
 * тат умножается на 5. Последовательная версия этого кода рабо-
 * тает правильно, но при распараллеливании появляется ошиб-
 * ка. Преобразуйте эту программу в параллельную с помощью
 * потоковой библиотеки и исправьте ошибку
 */
public class Ex02 {
    public static void main(String[] args) {
        List<Integer> list = asList(1, 2, 3);
        System.out.println(multiplyThrough(list));
        System.out.println(multiplyThroughParallel(list));

    }
     public static int multiplyThrough(List<Integer> linkedListOfNumbers){
        return linkedListOfNumbers.stream()
                .reduce(5, (acc, x)-> x * acc);
     }

    public static int multiplyThroughParallel(List<Integer> linkedListOfNumbers){
        return 5 * linkedListOfNumbers.parallelStream()
                .reduce(1, (acc, x)-> x * acc);
    }
}
