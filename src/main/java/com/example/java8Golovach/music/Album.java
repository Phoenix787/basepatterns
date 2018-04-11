package com.example.java8Golovach.music;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Album implements Performance {
    private String name;
    private List<Track> tracks;
    private List<Artist> artists;

    public Album(String name, List<Track> tracks, List<Artist> artists) {
        this.name = name;
        this.tracks = new ArrayList<>(tracks);
        this.artists = new ArrayList<>(artists);
    }

    public String getName() {
        return name;
    }

    @Override
    public Stream<Artist> getMusicians() {
        return artists.stream();
    }


    public List<Track> getTrackList() {
        return Collections.unmodifiableList(tracks);
    }

    public Stream<Track> getTracks() {
        return tracks.stream();
    }


    public List<Artist> getArtistList(){
        return artists;
    }


    public Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTrackList()){
                if (track.getLength() > 60){
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }
    //первый шаг рефакторинга
    public Set<String> findLongTracks_ref1(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(album ->
                        album.getTrackList()
                                .forEach(track -> {
                                    if (track.getLength() > 60){
                                        String name = track.getName();
                                        trackNames.add(name);
                                    }
                                }));
        return trackNames;
    }

    //2 шаг рефакторинга
    public Set<String> findLongTracks_ref2(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(album ->
                        album.getTracks()
                            .filter(track -> track.getLength() > 60)
                            .map(track -> track.getName())
                            .forEach(name ->trackNames.add(name)));
        return trackNames;
    }

    //3 шаг рефакторинга
    //Что нам в действительности нужно? Каким-то образом преобра-
    //зовать альбом в поток произведений. Мы знаем, что для трансфор-
    //мации или подмены предназначена операция map. Здесь же нужен бо-
    //лее продвинутый вариант map – операция
    // flatMap, которая возвращает
    //конкатенацию отдельных результирующих потоков. Заменив вызов
    //forEach на flatMap, получаем код,
    public Set<String> findLongTracks_ref3(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .flatMap(Album::getTracks)
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .forEach(name-> trackNames.add(name));
        return trackNames;
    }

    /**
     * Объект Set по-прежнему создается вручную, и элементы в него тоже
     * добавляются вручную. Хотелось бы, чтобы все вычисление состояло
     * только из цепочки потоковых вызовов.
     * Чтобы в конце построить список
     * List значений, мы вызывали collect(toList()). Ну а для построения
     * множества Set нужно вызвать collect(toSet()). Так что заменим по-
     * следний вызов forEach обращением к collect, после чего можно будет
     * удалить переменную trackNames.
     *
     * @param albums
     * @return
     */

    public Set<String> findLongTracks_ref4(List<Album> albums) {
        return albums.stream()
                .flatMap(Album::getTracks)
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(Collectors.toSet());
    }

    public Album copy(){
        List<Track> tracks = getTracks().map(Track::copy).collect(Collectors.toList());
        List<Artist> musicians = getMusicians().map(Artist::copy).collect(Collectors.toList());
        return new Album(name, tracks, musicians);
    }

    @Override
    public String toString() {
        return getName() +
                " Tracks: " + getTracks()
                .map(Track::getName)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public Artist getMainMusician() {
        return null;
    }
}
