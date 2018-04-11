package com.example.java8Golovach.lesson5;

import com.example.java8Golovach.music.Album;
import com.example.java8Golovach.music.Artist;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class TestCollectors {
    public static void main(String[] args) {
        //Создание конкретной коллекции с помощью метода toCollection
        List<String> list = asList("a", "bb", "ccc");
        list.stream().collect(Collectors.toCollection(TreeSet::new));

        //начиная с java9
        List<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6)
                .collect(Collectors.filtering(x -> x % 2 == 0, Collectors.toList()));

        System.out.println(ints);

        String s1 = Stream.of(1, 2, 3, 4, 5, 6)
                .collect(filtering(
                        x -> x % 2 == 0,
                        Collectors.mapping(
                                x -> Integer.toString(x),
                                Collectors.joining("-")
                        )
                ));
        System.out.println(s1);

        String s2 = Stream.of(2, 0, 1, 3, 2)
                .collect(Collectors.flatMapping(
                        x -> IntStream.range(0, x).mapToObj(Integer::toString),
                        Collectors.joining(", ")
                ));
        System.out.println(s2);

        int value = Stream.of(1,2,3,4,5,6)
                .collect(Collectors.reducing(
                        0, (a, b)-> a+b
                ));
        System.out.println(value);

        String s3 = Stream.of(1, 2, 3, 4, 5, 6)
                .collect(Collectors.reducing("", x -> Integer.toString(x), (a, b) -> a + b));
        System.out.println(s3);
    }

    //Нахождение группы с наибольшим числом участников
    public Optional<Artist> biggestGroup(Stream<Artist> artists) {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return artists.collect(maxBy(comparing(getCount)));
    }

    //Нахождение среднего числа произведений во всех альбомах из списка
    public double averageNumberOfTracks(List<Album> albums) {
        return albums.stream().collect(averagingInt(album -> album.getTrackList().size()));
    }


}
