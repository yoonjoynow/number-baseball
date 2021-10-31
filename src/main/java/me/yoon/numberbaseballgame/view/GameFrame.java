package me.yoon.numberbaseballgame.view;

import me.yoon.numberbaseballgame.listener.AttackButtonListener;
import me.yoon.numberbaseballgame.listener.HiddenNumberButtonListener;
import me.yoon.numberbaseballgame.listener.NumberButtonListener;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private JPanel topPanel = new JPanel();
    private JPanel boardPanel = new JPanel();
    private JPanel middlePanel = new JPanel();
    private JPanel bottomPanel = new JPanel();

    // Middle Panel Components
    private JButton hiddenNumberButton1 = new JButton();
    private JButton hiddenNumberButton2 = new JButton();
    private JButton hiddenNumberButton3 = new JButton();
    private JButton hiddenNumberButton4 = new JButton();

    private JButton attackNumberButton1 = new JButton();
    private JButton attackNumberButton2 = new JButton();
    private JButton attackNumberButton3 = new JButton();
    private JButton attackNumberButton4 = new JButton();

    // Bottom Panel Components
    private JButton buttonNum0 = new JButton();
    private JButton buttonNum1 = new JButton();
    private JButton buttonNum2 = new JButton();
    private JButton buttonNum3 = new JButton();
    private JButton buttonNum4 = new JButton();

    private JButton buttonNum5 = new JButton();
    private JButton buttonNum6 = new JButton();
    private JButton buttonNum7 = new JButton();
    private JButton buttonNum8 = new JButton();
    private JButton buttonNum9 = new JButton();

    private JButton enterButton = new JButton();
    private JButton clearButton = new JButton();
    private JButton startButton = new JButton();

    MyFrame() {
        setTitle("숫자 야구 게임");
        setSize(350, 570);

        setComponents();
        setPanels();
        setEvents(); // 이벤트 처리!

        setLayout(new GridLayout(4, 1));

        add(boardPanel); // 시작버튼과 상황판으로 나눠여함
        add(topPanel);
        add(middlePanel);
        add(bottomPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setPanels() {
        // Top Panel Settings
        topPanel.setLayout(new GridLayout(1, 1));
        topPanel.add(hiddenNumberButton1);
        topPanel.add(hiddenNumberButton2);
        topPanel.add(hiddenNumberButton3);
        topPanel.add(hiddenNumberButton4);

        // Middle Panel Settings
        middlePanel.setLayout(new GridLayout(1, 1));
        middlePanel.add(attackNumberButton1);
        middlePanel.add(attackNumberButton2);
        middlePanel.add(attackNumberButton3);
        middlePanel.add(attackNumberButton4);

        // Bottom Panel Settings
        bottomPanel.setLayout(new GridLayout(2, 6));

        bottomPanel.add(buttonNum0);
        bottomPanel.add(buttonNum1);
        bottomPanel.add(buttonNum2);
        bottomPanel.add(buttonNum3);
        bottomPanel.add(buttonNum4);
        bottomPanel.add(enterButton);

        bottomPanel.add(buttonNum5);
        bottomPanel.add(buttonNum6);
        bottomPanel.add(buttonNum7);
        bottomPanel.add(buttonNum8);
        bottomPanel.add(buttonNum9);
        bottomPanel.add(clearButton);
    }

    private void setComponents() {
//        textAreaNumbers.setText("0");
//        textAreaNumbers.setFont(new Font("돋움", Font.BOLD, 35));
//        textAreaNumbers.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//
//        textAreaPreNumbers.setFont(new Font("돋움", Font.PLAIN, 20));
//        textAreaPreNumbers.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        hiddenNumberButton1.setText("A");
        hiddenNumberButton2.setText("B");
        hiddenNumberButton3.setText("C");
        hiddenNumberButton4.setText("D");

        attackNumberButton1.setText("E");
        attackNumberButton2.setText("F");
        attackNumberButton3.setText("G");
        attackNumberButton4.setText("H");

        buttonNum0.setText("0");
        buttonNum1.setText("1");
        buttonNum2.setText("2");
        buttonNum3.setText("3");
        buttonNum4.setText("4");
        buttonNum5.setText("5");
        buttonNum6.setText("6");
        buttonNum7.setText("7");
        buttonNum8.setText("8");
        buttonNum9.setText("9");
        enterButton.setText("공격");
        enterButton.setBackground(Color.GRAY);
        clearButton.setText("초기화");
        clearButton.setBackground(Color.GRAY);
        startButton.setText("시작");
        startButton.setBackground(Color.GRAY);
    }

    private void setEvents() {
        setAttackButtonsEvent();
        setNumberButtonsEvent();
        setHiddenNumberButtonsEvent();
        setBasicButtonsEvent();
    }

    private void setNumberButtonsEvent() {
        NumberButtonListener numberButtonListener = NumberButtonListener.getListener();
        buttonNum0.addActionListener(numberButtonListener);
        buttonNum1.addActionListener(numberButtonListener);
        buttonNum2.addActionListener(numberButtonListener);
        buttonNum3.addActionListener(numberButtonListener);
        buttonNum4.addActionListener(numberButtonListener);
        buttonNum5.addActionListener(numberButtonListener);
        buttonNum6.addActionListener(numberButtonListener);
        buttonNum7.addActionListener(numberButtonListener);
        buttonNum8.addActionListener(numberButtonListener);
        buttonNum9.addActionListener(numberButtonListener);
    }

    private void setAttackButtonsEvent() {
        AttackButtonListener attackButtonListener = AttackButtonListener.getListener();
        attackNumberButton1.addActionListener(attackButtonListener);
        attackNumberButton2.addActionListener(attackButtonListener);
        attackNumberButton3.addActionListener(attackButtonListener);
        attackNumberButton4.addActionListener(attackButtonListener);
    }

    private void setHiddenNumberButtonsEvent() {
        HiddenNumberButtonListener hiddenNumberButtonListener = HiddenNumberButtonListener.getListener();
        hiddenNumberButton1.addActionListener(hiddenNumberButtonListener);
        hiddenNumberButton2.addActionListener(hiddenNumberButtonListener);
        hiddenNumberButton3.addActionListener(hiddenNumberButtonListener);
        hiddenNumberButton4.addActionListener(hiddenNumberButtonListener);
    }

    private void setBasicButtonsEvent() {
        clearButton.addActionListener(e -> {

        });
    }

    public static void main(String[] args) {
        new MyFrame();
    }

}
