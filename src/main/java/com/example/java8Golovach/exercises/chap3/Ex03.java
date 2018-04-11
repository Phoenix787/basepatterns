package com.example.java8Golovach.exercises.chap3;

import com.example.java8Golovach.music.Album;
import com.example.java8Golovach.music.Artist;
import com.example.java8Golovach.music.Track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Функцию, которая получает альбомы и возвращает список
 * альбомов, содержащих не более трех произведений
 */
public class Ex03 {
    public static void main(String[] args) {
        Artist johnColtrane = new Artist("John Coltrane", "US");

        List<Album> albums = getData(johnColtrane);

        for (Album album : getAlbumWithMoreThreeTracks(albums)){
            System.out.println(album);
        }
    }



    public static List<Album> getAlbumWithMoreThreeTracks(List<Album> input) {
        return input.stream()
                .filter(album -> album.getTrackList().size() <= 3)
                .collect(Collectors.toList());
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
