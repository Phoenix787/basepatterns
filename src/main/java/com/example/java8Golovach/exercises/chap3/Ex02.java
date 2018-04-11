package com.example.java8Golovach.exercises.chap3;

import com.example.java8Golovach.music.Artist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Функцию, которая получает исполнителя и возвращает спи-
 * сок строк, содержащих имена и место происхождения
 */
public class Ex02 {
    public static void main(String[] args) {
        List<Artist> artists = Arrays.asList(new Artist("The Beatles", "Liverpull"),
                new Artist("Scorp", "London"),
                new Artist("Brown", "London"),
                new Artist("Cool", "NY"));

        for (String artist : getNamesAndOrigin(artists)) {
            System.out.println(artist);
        }

    }

    public static List<String> getNamesAndOrigin(List<Artist> artists){
       return artists.stream()
               .map(x -> x.getName() + " from " + x.getNationality())
               .collect(Collectors.toList());
    }
}
