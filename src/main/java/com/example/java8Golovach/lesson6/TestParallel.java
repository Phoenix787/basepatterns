package com.example.java8Golovach.lesson6;

import com.example.java8Golovach.music.Album;
import com.example.java8Golovach.music.Artist;
import com.example.java8Golovach.music.Track;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * вычисляется полная длительность звучания последовательности
 * альбомов. Каждый альбом преобразуется в набор составляющих его
 * произведений, после чего длительности произведений суммируются
 */

public class TestParallel {


    public static void main(String[] args) {
        List<Album> albums = getData(new Artist("The", "GB"));
        System.out.println(new TestParallel().serialArraySum(albums));
    }




//последовательное суммирование длительностей произведений
    public long serialArraySum(List<Album> albums){
        return albums
                .stream()
                .flatMap(Album::getTracks)
                .mapToLong(Track::getLength)
                .sum();
    }

    //параллельное суммирование длительностей произведений
    public long parallelArraySum(List<Album> albums) {
        return albums.parallelStream()
                .flatMap(Album::getTracks)
                .mapToLong(Track::getLength)
                .sum();
    }





    private static List<Album> getData(Artist artist) {
        return Arrays.asList(new Album("sample 1",
                        asList(new Track("short track", 30),
                                new Track("short track 2", 30),
                                new Track("short track 3", 30),
                                new Track("short track 4", 30),
                                new Track("short track 5", 30)),
                        Collections.singletonList(artist)), new Album("sample 2",
                        asList(new Track("track", 30),
                                new Track("track 2", 30),
                                new Track("track 3", 30),
                                new Track("track 4", 30),
                                new Track("track 5", 30),
                                new Track("track 6", 30)),
                        Collections.singletonList(artist)),
                new Album("sample 3",
                        asList(new Track("track", 30),
                                new Track("track 2", 30),
                                new Track("track 3", 30)),
                        Collections.singletonList(artist)),
                new Album("sample 4",
                        asList(new Track("track", 30),
                                new Track("track 2", 30)),
                        Collections.singletonList(artist)));
    }

}
