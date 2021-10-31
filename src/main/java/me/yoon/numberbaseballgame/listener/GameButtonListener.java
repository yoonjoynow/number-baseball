package me.yoon.numberbaseballgame.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class GameButtonListener implements ActionListener {

    protected static final int MAX_SIZE = 4;
    protected List<Integer> numberList = new ArrayList<>(MAX_SIZE);

    @Override
    public void actionPerformed(ActionEvent e) {
        checkFull();
        JButton button = (JButton) e.getSource();

        int number = Integer.parseInt(button.getText());
        addNumber(number);
    }

    private void addNumber(int number) {
        if (hasElement(number)) {
            JOptionPane.showMessageDialog(null, "[ " + number + " ] 이미 고른 숫자입니다.");
        } else {
            this.numberList.add(number);
        }
    }

    private void checkFull() {
        if (MAX_SIZE <= this.numberList.size()) {
            this.numberList.clear();
        }
    }

    private boolean hasElement(int number) {
        return this.numberList.contains(number);
    }

    public List<Integer> getNumberList() {
        return this.numberList;
    }

}
