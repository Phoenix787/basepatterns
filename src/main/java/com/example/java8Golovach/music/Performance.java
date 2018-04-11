package com.example.java8Golovach.music;

import java.util.stream.Stream;

public interface Performance {
    String getName();
    public Stream<Artist> getMusicians();

    public default Stream<Artist> getAllMusicians(){
        return getMusicians().flatMap(artist ->
                Stream.concat(Stream.of(artist), artist.getMembers()));
    }
}
