package com.example.basepatterns.behavioral.state.audioplayer;

import com.example.basepatterns.behavioral.state.audioplayer.ui.Player;
import com.example.basepatterns.behavioral.state.audioplayer.ui.UI;

public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
