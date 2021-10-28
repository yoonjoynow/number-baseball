package me.yoon.numberbaseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer extends Player {

    List<Integer> expectedNumbers;

    public Computer() {
        expectedNumbers = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            expectedNumbers.add(i);
        }
    }

    @Override
    protected void pickHiddenNumbers() {
        while (this.hiddenNumbers.size() < this.MAX_SIZE) {
            int newNumber = createRandomNumber();
            if (this.hiddenNumbers.contains(newNumber)) {
                continue;
            }

            this.hiddenNumbers.add(newNumber);
        }
    }

    private int createRandomNumber() {
        return new Random().nextInt(9);
    }

    @Override
    protected void attack() {

    }



    @Override
    protected void defend() {

    }

    private void excludeOutNumbers(int[] outNumbers) {
        for (int outNumber : outNumbers) {
            this.expectedNumbers.remove((Object) outNumber);
        }
    }

    @Override
    protected List<Integer> pickAttackNumbers() {
        return null;
    }
}
