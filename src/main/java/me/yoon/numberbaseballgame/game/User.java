package me.yoon.numberbaseballgame;

import javafx.event.ActionEvent;
import me.yoon.view.Hello;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Player {

    private int pickNumber(ActionEvent event) {
        String text = ((JButton) event.getSource()).getText();
        System.out.println("text = " + text);
        return Integer.valueOf(text);
    }

    @Override
    public void pickHiddenNumbers() {
//        Scanner scanner = new Scanner(System.in);
        JOptionPane.showMessageDialog(null, "네 자리의 히든넘버를 선택해주세요");

        while (this.hiddenNumbers.size() != 4) {
//            int randomNumber = scanner.nextInt();

            int number = 0;

            if (hasElement(this.hiddenNumbers, number)) {
                continue;
            }

            this.hiddenNumbers.add(number);
        }

//        System.out.println("나의 히든넘버 : " + this.hiddenNumbers);
        JOptionPane.showMessageDialog(null, "나의 히든넘버 : " + this.hiddenNumbers);
    }

    @Override
    public List<Integer> attack() {
        System.out.println("공격 숫자 네 자리를 정하세요");
        List<Integer> attackNumbers = pickAttackNumbers();
        System.out.println("공격 숫자 : " + attackNumbers.toString());
        return attackNumbers;
    }

    @Override
    protected List<Integer> pickAttackNumbers() {
        List<Integer> attackNumbers = new ArrayList<>(this.MAX_SIZE);
        Scanner scanner = new Scanner(System.in);
        while (attackNumbers.size() < this.MAX_SIZE) {
            int newNumber = scanner.nextInt();
            if (hasElement(attackNumbers, newNumber)) {
                continue;
            }

            attackNumbers.add(newNumber);
        }

        return attackNumbers;
    }

    private boolean hasElement(List<Integer> list, int integer) {
        if (list.contains(integer)) {
            System.out.println("이미 고른 숫자입니다.");
            return true;
        }

        return false;
    }

}
