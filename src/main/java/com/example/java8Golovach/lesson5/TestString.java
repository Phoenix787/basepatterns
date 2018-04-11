package com.example.java8Golovach.lesson5;

import com.example.java8Golovach.music.Artist;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class TestString {
    public static void main(String[] args) {

        List<Artist> artists = asList(new Artist("George Harrison", "GB"),
                new Artist("John Lennon", "GB"),
                new Artist("Paul MacCartney", "GB"),
                new Artist("Ringo Star", "GB"),
                new Artist("The Beatles", "GB"));
        //до выхода Java8
        StringBuilder builder = new StringBuilder("[");
        for (Artist artist : artists) {
            if (builder.length() > 1) {
                builder.append(", ");
            }
            String name = artist.getName();
            builder.append(name);
        }
        builder.append("]");
        String result = builder.toString();

        System.out.println(result);

        //форматирование имен исполнителей с помощью потоков и коллекторов
        String res = artists.stream().map(Artist::getName).
                collect(Collectors.joining(", ", "[", "]"));

        System.out.println(res);
    }
}
