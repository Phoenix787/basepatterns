package com.example.java8Golovach.lesson7;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class TestLambdaTestingTest {
    /**
     * тест, проверяющий, что если в потоке есть несколько слов, то
     * все они преобразуются в верхний регистр
     */
    @Test
    public void allUpperCase() {
        List<String> input = asList("a", "b", "hello");
        List<String> result = TestLambdaTesting.allUpperCase(input);
        assertEquals(asList("A", "B", "HELLO"), result);
    }

    /**
     * Чтобы протестировать этот метод, нам нужно было бы для каждого
     * интересующего нас случая создать список и проверить результат его
     * преобразования.
     */
    @Test
    public void twoLettersStringConvertToUppercaseLambdas(){
        List<String> input = asList("ab");
        List<String> result = TestLambdaTesting.elementFirstToUpperCaseLambdas(input);
        assertEquals(asList("Ab"), result);
    }

    /**
     * Тест строки из двух символов примененный к одному методу
     */
    @Test
    public void twoLettersStringConvertedToUppercaseLambdas(){
        String input = "ab";
        String result = TestLambdaTesting.firstToUpperCase(input);
        assertEquals("Ab", result);
    }
}