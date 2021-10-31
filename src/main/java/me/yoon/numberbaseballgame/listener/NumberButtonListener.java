package me.yoon.numberbaseballgame.listener;

public class NumberButtonListener extends GameButtonListener {

    private static NumberButtonListener listener;

    private NumberButtonListener() {

    }

    public static NumberButtonListener getListener() {
        if (listener == null) {
            listener = new NumberButtonListener();
        }

        return listener;
    }
}
