package me.yoon.numberbaseballgame;

import java.util.*;

public class RandomNumberGenerator {

    public static final int MAX_NUMBER = 4;

    public List<Integer> createHiddenNumbers() {
        List<Integer> hiddenNumbers = new ArrayList<>();
        while (hiddenNumbers.size() < MAX_NUMBER) {
            int newNumber = createRandomNumber();
            if (! hiddenNumbers.contains(newNumber)) {
                hiddenNumbers.add(newNumber);
            }
        }

        return hiddenNumbers;
    }

    private int createRandomNumber() {
        return new Random().nextInt(9);
    }

}
