package com.example.java8Golovach.music;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Artist {
    private String name; // имя или название исполнителя
    private List<Artist> members; // другие исполнители, входящие в состав группы (может быть пустым
    private String nationality; //место где возникла группа

    public Artist(String name, List<Artist> members, String nationality) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        Objects.requireNonNull(nationality);
        this.name = name;
        this.members = new ArrayList<>(members);
        this.nationality = nationality;
    }

    public Artist(String name, String nationality){
        this(name, Collections.emptyList(), nationality);
    }

    public String getName() {
        return name;
    }

    public Stream<Artist> getMembers() {
        return members.stream();
    }


    public String getNationality() {
        return nationality;
    }

    public boolean isSolo(){
        return members.isEmpty();
    }

    public boolean isFrom(String nationality) {
        return this.nationality.equalsIgnoreCase(nationality);
    }

    @Override
    public String toString() {
        return getName();
    }

    public Artist copy(){
        List<Artist> members = getMembers().map(Artist::copy).collect(Collectors.toList());
        return new Artist(name, members, nationality);
    }
}
