package com.example.java8Golovach.music;

public final class Track {
    private String name;
    private long length;

    public Track(String name, long length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

     public long getLength() {
        return length;
    }

    public Track copy() {
        return new Track(name, length);
    }

}
