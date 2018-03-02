package com.example.basepatterns.behavioral.state.audioplayer.state;

import com.example.basepatterns.behavioral.state.audioplayer.ui.Player;

public class PlayState extends State {
    public PlayState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        player.setCurrentTrackAfterStop();
        return "Locked...";
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Paused";
    }

    @Override
    public String onNext() {
        return player.nextTrack();
    }

    @Override
    public String onPrevious() {
        return player.previousTrack();
    }
}
