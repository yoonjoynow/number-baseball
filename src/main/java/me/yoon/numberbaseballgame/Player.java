package me.yoon.numberbaseballgame;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    protected static final int MAX_SIZE = 4;
    protected List<Integer> hiddenNumbers = new ArrayList<>(MAX_SIZE);

    protected abstract void pickHiddenNumbers();
    protected abstract void attack();
    protected abstract List<Integer> pickAttackNumbers();
    protected abstract void defend();

    public List<Integer> getHiddenNumbers() {
        return hiddenNumbers;
    }

}
