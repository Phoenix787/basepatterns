package com.example.java8Golovach;

import com.example.java8Golovach.music.Album;
import com.example.java8Golovach.music.Artist;
import com.example.java8Golovach.music.Track;

import java.util.Collections;
import java.util.LongSummaryStatistics;

import static java.util.Arrays.asList;

public class TestSummaryStatics {
    public static void main(String[] args) {
        Album album = new Album("sample 1",
                asList(new Track("short track", 30),
                        new Track("short track 2", 60),
                        new Track("short track 3", 45),
                        new Track("short track 4", 20),
                        new Track("short track 5", 30)),
                Collections.singletonList(new Artist("The", "US")));

        printTrackLengthStatics(album);
    }

    private static void printTrackLengthStatics(Album album) {
        LongSummaryStatistics trackLengthStat =
                album.getTracks()
                        .mapToLong(track->track.getLength())
                        .summaryStatistics();

        System.out.printf("Max:  %d, Min: %d, Ave: %f Sum: %d",
                trackLengthStat.getMax(),
                trackLengthStat.getMin(),
                trackLengthStat.getAverage(),
                trackLengthStat.getSum()
                );
    }
}
