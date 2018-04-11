package com.example.java8Golovach.lesson5;

import com.example.java8Golovach.music.Album;
import com.example.java8Golovach.music.Artist;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

/**
 * partitioningBy​(Predicate predicate)
 * partitioningBy​(Predicate predicate, Collector downstream)
 * Ещё один интересный метод. Разбивает последовательность элементов по какому-либо критерию.
 * В одну часть  * попадают все элементы, которые удовлетворяют переданному условию,
 * во вторую — все, которые не удовлетворяют.
 */

public class TestPartitioningBy {
    public static void main(String[] args) {

        Map<Boolean, List<String>> map1 = Stream.of(
                "ab", "c", "def", "gh", "ijk", "l", "mnop")
                .collect(Collectors.partitioningBy(s -> s.length() <=2));
        map1.entrySet().forEach(System.out::println);

        Map<Boolean, String> map2 = Stream.of(
                "ab", "c", "def", "gh", "ijk", "l", "mnop")
                .collect(Collectors.partitioningBy(s->s.length() <= 2,
                        Collectors.mapping(
                                String::toUpperCase,
                                Collectors.joining()
                        )));
        map2.entrySet().forEach(System.out::println);


    }

    //разбиение потока исполнителей на группы и артистов
    public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artistStream) {
        return artistStream.collect(partitioningBy(artist -> artist.isSolo()));
    }
    //тоже самое с помощью ссылки на метод
    public Map<Boolean, List<Artist>> bandsAndSoloRef(Stream<Artist> artists){
        return artists.collect(partitioningBy(Artist::isSolo));
    }

    //группировка альбомов по основному исполнителю
    public Map<Artist, List<Album>> albumGroupByArtist(Stream<Album> albums) {
        return albums.collect(groupingBy(album -> album.getMainMusician()));
    }



}
