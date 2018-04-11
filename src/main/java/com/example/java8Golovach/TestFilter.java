package com.example.java8Golovach;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * filter
 * Поймав себя на том, что перебираете коллекцию в цикле и проверяете
 * каждый элемент, подумайте об использовании методаfilter из интерфейса Stream
 */
public class TestFilter {
    public static void main(String[] args) {
        List<String> beginningWithNumbers = new ArrayList<>();
        for (String value : asList("a", "1abc", "abc1")){
            if (isDigit(value.charAt(0))) {
                beginningWithNumbers.add(value);
            }
        }
        assertEquals(asList("1abc"), beginningWithNumbers);

        //c помощью потокового API
        List<String> beginWN = Stream.of("a", "1abc", "abc1")
                .filter(string -> isDigit(string.charAt(0)))
                .collect(Collectors.toList());

        assertEquals(asList("1abc"), beginWN);
    }


}
