package me.yoon.numberbaseballgame.game;

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
        while (this.hiddenNumbers.size() < MAX_SIZE) {
            int newNumber = createRandomNumber();
            if (this.hiddenNumbers.contains(newNumber)) {
                continue;
            }

            this.hiddenNumbers.add(newNumber);
        }

        System.out.println("컴퓨터 히든 넘버 : " + getHiddenNumbers().toString());
    }

    private int createRandomNumber() {
        return new Random().nextInt(9);
    }

    @Override
    protected List<Integer> attack() {
        // 컴퓨터가 계산하는 시간 여유분 주기
        try {
            Thread.sleep(createRandomNumber() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Integer> attackNumbers = pickAttackNumbers();
        System.out.println("컴퓨터의 공격 숫자 : " + attackNumbers.toString());
        return attackNumbers;
    }

    public void excludeOutNumbers(List<Integer> outNumbers) {
        for (int outNumber : outNumbers) {
            // 아웃된 넘버들은 다음 추론에서 제외
            this.expectedNumbers.remove((Object) outNumber);
        }
        System.out.println("컴퓨터의 추론 범위 : " + expectedNumbers.toString());
    }

    @Override
    protected List<Integer> pickAttackNumbers() {
        /**
         *    1. 우선 랜덤 숫자를 0 ~ 9 까지 획득
         *    2. 이미 획득한 숫자이면 제외
         *    3. expectedNumbers에 없는 숫자면 제외
         *    4. attackNumbers의 size가 4일 때까지 반복
         *    5. attackNumbers 리턴
         */
        List<Integer> attackNumbers = new ArrayList<>(MAX_SIZE);
        while (attackNumbers.size() < MAX_SIZE) {
            int randomNumber = createRandomNumber();
            addNumber(attackNumbers, randomNumber);
        }

        return attackNumbers;
    }

    private void addNumber(List<Integer> attackNumbers, int randomNumber) {
        if (expectedNumbers.contains(randomNumber) &&
            ! attackNumbers.contains(randomNumber)) {
            attackNumbers.add(randomNumber);
        }
    }

}
