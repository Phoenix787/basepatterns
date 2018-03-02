package com.example.basepatterns.behavioral.state.audioplayer.state;

import com.example.basepatterns.behavioral.state.audioplayer.ui.Player;

/**
 * Общий интерфейс состояний
 */
public abstract class State {
    Player player;

    /**
     * Контекст передаёт себя в конструктор состояния, чтобы состояние могло
     * обращаться к его данным и методам в будущем, если потребуется.
     */

    public State(Player player) {
        this.player = player;
    }

    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();
}
