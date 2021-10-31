package me.yoon.numberbaseballgame.listener;

import java.awt.event.ActionEvent;

public class HiddenNumberButtonListener extends GameButtonListener {

    private static HiddenNumberButtonListener listener;

    private HiddenNumberButtonListener() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static HiddenNumberButtonListener getListener() {
        if (listener == null) {
            listener = new HiddenNumberButtonListener();
        }

        return listener;
    }
}
