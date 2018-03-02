package com.example.basepatterns.behavioral.state.audioplayer.ui;

import com.example.basepatterns.behavioral.state.audioplayer.state.ReadyState;
import com.example.basepatterns.behavioral.state.audioplayer.state.State;

import java.util.ArrayList;
import java.util.List;

public class Player  {
    private State state;
    private boolean playing = false;
    private List<String> playlist = new ArrayList<>();
    private int currentTrack = 0;

    public Player(){
        this.state = new ReadyState(this);
        setPlaying(true);
        for (int i = 0; i < 12; i++) {
            playlist.add("Track" + i);
        }
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState(){
        return state;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPlaying() {
        return playing;
    }

    public String startPlaying(){
        return "Playing " + getTrack(currentTrack);
    }

    private String getTrack(int currentTrack) {
        return playlist.get(currentTrack);
    }

    public String nextTrack(){
        currentTrack++;
        if (currentTrack > playlist.size()-1){
            currentTrack = 0;
        }
        return "Playing " + getTrack(currentTrack);
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playlist.size() - 1;
        }
        return "Playing " + getTrack(currentTrack);
    }

    public void setCurrentTrackAfterStop(){
        currentTrack = 0;
    }

}
