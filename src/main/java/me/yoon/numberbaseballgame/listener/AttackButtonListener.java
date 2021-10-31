package me.yoon.numberbaseballgame.listener;

public class AttackButtonListener extends GameButtonListener {

    private static AttackButtonListener listener;

    private AttackButtonListener() {

    }

    public static AttackButtonListener getListener() {
        if (listener == null) {
            listener = new AttackButtonListener();
        }

        return listener;
    }

}
