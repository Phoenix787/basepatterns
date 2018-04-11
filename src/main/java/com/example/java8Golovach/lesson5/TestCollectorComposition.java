package com.example.java8Golovach.lesson5;

import com.example.java8Golovach.music.Album;
import com.example.java8Golovach.music.Artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class TestCollectorComposition {
    public static void main(String[] args) {
        //Наивный подход к подсчету количества альбомов для
        //каждого исполнителя
        //Это императивный код, не допускающий автоматического распараллеливания.

        List<Album> albums = asList(
                new Album("First", null, asList(new Artist("George", "GB"))),
                new Album("Second", null, asList(new Artist("George", "GB"))),
                new Album("Third", null, asList(new Artist("George", "GB"))),
                new Album("By", null, asList(new Artist("By", "US"))),
                new Album("GRO", null, asList(new Artist("GRO", "GB"))));

        Map<Artist, List<Album>> albumsByArtist = albums.stream().collect(groupingBy(album -> album.getMainMusician()));
        Map<Artist, Integer> numberOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            numberOfAlbums.put(entry.getKey(), entry.getValue().size());
        }


    }

    //Использование коллекторов для подсчета количества
    //альбомов для каждого исполнителя
    public Map<Artist, Long> numberOfAlbum(Stream<Album> albums) {
        return albums.collect(groupingBy(album -> album.getMainMusician(), Collectors.counting()));
    }

    //Наивный подход к нахождению названий всех альбомов, в записи который участвовал исполнитель
    public Map<Artist, List<String>> nameOfAlbumsDumb(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(groupingBy(album -> album.getMainMusician()));
        Map<Artist, List<String>> nameOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            nameOfAlbums.put(entry.getKey(), entry.getValue()
                    .stream()
                    .map(Album::getName)
                    .collect(Collectors.toList()));
        }
        return nameOfAlbums;
    }

    //более элегантный подход
    public Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums){
        return albums.collect(groupingBy(Album::getMainMusician, mapping(Album::getName, toList())));
    }


}
