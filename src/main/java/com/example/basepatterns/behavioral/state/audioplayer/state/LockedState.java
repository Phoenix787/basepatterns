package com.example.basepatterns.behavioral.state.audioplayer.state;

import com.example.basepatterns.behavioral.state.audioplayer.ui.Player;

/**
 * Конкретные состояния реализуют методы абстрактного состояния по-своему.
 */
public class LockedState extends State {

    /**
     * Контекст передаёт себя в конструктор состояния, чтобы состояние могло
     * обращаться к его данным и методам в будущем, если потребуется.
     *
     * @param player
     */
    public LockedState(Player player) {
        super(player);
        player.setPlaying(false);
    }

    @Override
    public String onLock() {
        if (player.isPlaying()) {
            player.changeState(new ReadyState(player));
            return "Stop playing...";
        } else {
            return "Locked";
        }
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Ready";
    }

    @Override
    public String onNext() {
        return "Locked";
    }

    @Override
    public String onPrevious() {
        return "Locked";
    }
}
