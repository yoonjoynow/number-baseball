package me.yoon.numberbaseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Player {

    @Override
    public void pickHiddenNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("네 자리의 히든넘버를 선택해주세요");

        while (this.hiddenNumbers.size() != 4) {
            int randomNumber = scanner.nextInt();
            if (isContained(this.hiddenNumbers, randomNumber)) {
                continue;
            }

            this.hiddenNumbers.add(randomNumber);
        }

        System.out.println("히든넘버 : " + this.hiddenNumbers);
    }

    @Override
    public List<Integer> attack() {
        System.out.println("공격 숫자 네 자리를 정하세요");
        List<Integer> attackNumbers = pickAttackNumbers();
        System.out.println("공격 숫자 : " + attackNumbers.toString());
        return attackNumbers;
    }


    // TODO : 구현 감추기
    @Override
    protected List<Integer> pickAttackNumbers() {
        List<Integer> attackNumbers = new ArrayList<>(this.MAX_SIZE);
        Scanner scanner = new Scanner(System.in);
        while (attackNumbers.size() < this.MAX_SIZE) {
            int newNumber = scanner.nextInt();
            if (isContained(attackNumbers, newNumber)) {
                continue;
            }

            attackNumbers.add(newNumber);
        }

        return attackNumbers;
    }

    private boolean isContained(List<Integer> list, int integer) {
        if (list.contains(integer)) {
            System.out.println("이미 고른 숫자입니다.");
            return true;
        }

        return false;
    }

}
