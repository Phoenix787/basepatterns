package com.example.java8Golovach.lesson5;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestOrderStream {
    public static void main(String[] args) {
        //Предположение об упорядоченности в этомутверждении истинно
        List<Integer> list = asList(1, 2, 3, 4);
        List<Integer> sameOrder = list.stream().collect(Collectors.toList());

        assertEquals(list, sameOrder);

        //Истинность предположения об упорядоченности
        //не гарантирована
//        Set<Integer> numSet = new HashSet<>(asList(4, 3, 2, 1));
//        List<Integer> collect = numSet.stream().collect(Collectors.toList());
//        assertEquals(asList(4,3,2,1), collect);

        //Создание порядка поступления
        Set<Integer> num = new HashSet<>(asList(4, 3, 2, 1));
        List<Integer> sorted = num.stream().sorted().collect(Collectors.toList());

        assertEquals(asList(1,2,3,4), sorted);

        //предположения об упорядочении
        List<Integer> numbers = asList(1, 2, 3, 4);
        List<Integer> stillOrdered = numbers.stream().map(x -> x + 1).collect(Collectors.toList());

        //порядок поступелния четко определен
        assertEquals(asList(2, 3, 4, 5), stillOrdered);

        Set<Integer> unordered = new HashSet<>(numbers);
        List<Integer> stillUnordered = unordered.stream().map(x -> x + 1).collect(Collectors.toList());

        //невозможно ничего утверждать о порядке поступления
        assertThat(stillUnordered, hasItem(2));
        assertThat(stillUnordered, hasItem(3));
        assertThat(stillUnordered, hasItem(4));
        assertThat(stillUnordered, hasItem(5));

    }
}
