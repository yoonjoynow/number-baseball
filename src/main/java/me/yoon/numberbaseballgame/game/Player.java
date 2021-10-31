package me.yoon.numberbaseballgame.game;

import me.yoon.numberbaseballgame.view.GameFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    protected static final int MAX_SIZE = 4;
    protected List<Integer> hiddenNumbers = new ArrayList<>(MAX_SIZE);

    protected abstract void pickHiddenNumbers();
    protected abstract List<Integer> attack();
    protected abstract List<Integer> pickAttackNumbers();

    public List<Integer> getHiddenNumbers() {
        return hiddenNumbers;
    }

    protected void printMessageAtTopBoard(String message) {
        JTextArea topBoard = GameFrame.getInstance().getTopBoard();
        topBoard.setText(message);
    }

    protected void printMessageAtBottomBoard(String message) {
        JTextArea bottomBoard = GameFrame.getInstance().getBottomBoard();
        bottomBoard.setText(message);
    }

}
