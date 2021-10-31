package me.yoon.numberbaseballgame.game;

import me.yoon.numberbaseballgame.listener.GameButtonListener;
import me.yoon.numberbaseballgame.listener.NumberButtonListener;
import me.yoon.numberbaseballgame.view.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class User extends Player {

    NumberButtonListener numberButtonListener = NumberButtonListener.getListener();
    List<Integer> numberList = NumberButtonListener.getListener().getNumberList();

    @Override
    public void pickHiddenNumbers() {
        JOptionPane.showMessageDialog(null, "네 자리의 히든넘버를 선택해주세요");
        getPressedNumbers(this.numberButtonListener);
        addNumbers(this.numberList, this.hiddenNumbers);
        JOptionPane.showMessageDialog(null, "나의 히든넘버 : " + this.hiddenNumbers);
        changeHiddenButtonText();
    }

    private List<Integer> getPressedNumbers(GameButtonListener listener) {
        this.numberList.clear();
        List<Integer> numberList = listener.getNumberList();
        int size = 0;
        while (size < 5) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            size = numberList.size();
            if (size == 4) {
                break;
            }
        }

        return numberList;
    }

    private void addNumbers(List<Integer> listA, List<Integer> listB) {
        listB.addAll(listA);
    }

    @Override
    public List<Integer> attack() {
        JOptionPane.showMessageDialog(null, "공격 숫자 네 자리를 정하세요");
        List<Integer> attackNumbers = pickAttackNumbers();
        JOptionPane.showMessageDialog(null, "나의 공격 숫자 : " + attackNumbers.toString());
        changeAttackButtonText();
        return attackNumbers;
    }

    @Override
    protected List<Integer> pickAttackNumbers() {
        return getPressedNumbers(numberButtonListener);
    }

    private void changeHiddenButtonText() {
        List<JButton> hiddenNumberButtons = GameFrame.getInstance().getHiddenNumberButtons();
        for (int i = 0; i < hiddenNumberButtons.size(); i++) {
            JButton button = hiddenNumberButtons.get(i);
            int number = this.hiddenNumbers.get(i);
            button.setText(String.valueOf(number));
            button.setBackground(Color.YELLOW);
        }
    }

    private void changeAttackButtonText() {
        List<JButton> attackNumberButtons = GameFrame.getInstance().getAttackNumberButtons();
        for (int i = 0; i < attackNumberButtons.size(); i++) {
            JButton button = attackNumberButtons.get(i);
            int number = this.numberList.get(i);
            button.setText(String.valueOf(number));
            button.setBackground(Color.CYAN);
        }
    }

}
