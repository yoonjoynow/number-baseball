package me.yoon.numberbaseballgame.view;

import me.yoon.numberbaseballgame.listener.AttackButtonListener;
import me.yoon.numberbaseballgame.listener.HiddenNumberButtonListener;
import me.yoon.numberbaseballgame.listener.NumberButtonListener;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameFrame extends JFrame {

    private static GameFrame instance;

    private JPanel topPanel = new JPanel();
    private JPanel boardPanel = new JPanel();
    private JPanel middlePanel = new JPanel();
    private JPanel bottomPanel = new JPanel();

    JTextArea topBoard = new JTextArea();
    JTextArea bottomBoard = new JTextArea();

    private JButton hiddenNumberButton1 = new JButton("0", new ImageIcon("images/0.png"));
    private JButton hiddenNumberButton2 = new JButton();
    private JButton hiddenNumberButton3 = new JButton();
    private JButton hiddenNumberButton4 = new JButton();

    private JButton attackNumberButton1 = new JButton();
    private JButton attackNumberButton2 = new JButton();
    private JButton attackNumberButton3 = new JButton();
    private JButton attackNumberButton4 = new JButton();

    private JButton numberButton0 = new JButton();
    private JButton numberButton1 = new JButton();
    private JButton numberButton2 = new JButton();
    private JButton numberButton3 = new JButton();
    private JButton numberButton4 = new JButton();

    private JButton numberButton5 = new JButton();
    private JButton numberButton6 = new JButton();
    private JButton numberButton7 = new JButton();
    private JButton numberButton8 = new JButton();
    private JButton numberButton9 = new JButton();

    private JButton exitButton = new JButton();
    private JButton clearButton = new JButton();
    private JButton startButton = new JButton();

    private GameFrame() {
        setTitle("숫자 야구 게임");
        setSize(350, 570);

        setComponents();
        setPanels();
        setEvents(); // 이벤트 처리!

        setLayout(new GridLayout(4, 1));

        add(boardPanel);
        add(topPanel);
        add(middlePanel);
        add(bottomPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setPanels() {
        boardPanel.setLayout(new GridLayout(2, 1));
        boardPanel.add(topBoard);
        boardPanel.add(bottomBoard);

        topPanel.setLayout(new GridLayout(1, 1));
        topPanel.add(hiddenNumberButton1);
        topPanel.add(hiddenNumberButton2);
        topPanel.add(hiddenNumberButton3);
        topPanel.add(hiddenNumberButton4);

        middlePanel.setLayout(new GridLayout(1, 1));
        middlePanel.add(attackNumberButton1);
        middlePanel.add(attackNumberButton2);
        middlePanel.add(attackNumberButton3);
        middlePanel.add(attackNumberButton4);

        bottomPanel.setLayout(new GridLayout(2, 6));
        bottomPanel.add(numberButton0);
        bottomPanel.add(numberButton1);
        bottomPanel.add(numberButton2);
        bottomPanel.add(numberButton3);
        bottomPanel.add(numberButton4);
        bottomPanel.add(exitButton);

        bottomPanel.add(numberButton5);
        bottomPanel.add(numberButton6);
        bottomPanel.add(numberButton7);
        bottomPanel.add(numberButton8);
        bottomPanel.add(numberButton9);
        bottomPanel.add(clearButton);
    }

    private void setComponents() {
        topBoard.setText("숫자 야구 게임");
        topBoard.setFont(new Font("돋움", Font.BOLD, 35));
        topBoard.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        bottomBoard.setFont(new Font("돋움", Font.PLAIN, 16));
        bottomBoard.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        setHiddenNumberButtonsSettings();
        setAttackNumberButtonsSettings();
        setNumberButtonsSettings();
        setBasicButtonsSettings();
    }

    private void setBasicButtonsSettings() {
        exitButton.setText("종료");
        exitButton.setBackground(Color.GRAY);
        clearButton.setText("지우기");
        clearButton.setBackground(Color.GRAY);
        startButton.setText("시작");
        startButton.setBackground(Color.GRAY);
    }

    private void setAttackNumberButtonsSettings() {
        attackNumberButton1.setText("E");
        attackNumberButton2.setText("F");
        attackNumberButton3.setText("G");
        attackNumberButton4.setText("H");

        attackNumberButton1.setEnabled(false);
        attackNumberButton2.setEnabled(false);
        attackNumberButton3.setEnabled(false);
        attackNumberButton4.setEnabled(false);
    }

    private void setHiddenNumberButtonsSettings() {
        hiddenNumberButton1.setText("A");
        hiddenNumberButton2.setText("B");
        hiddenNumberButton3.setText("C");
        hiddenNumberButton4.setText("D");

        hiddenNumberButton1.setEnabled(false);
        hiddenNumberButton2.setEnabled(false);
        hiddenNumberButton3.setEnabled(false);
        hiddenNumberButton4.setEnabled(false);
    }

    private void setNumberButtonsSettings() {
        numberButton0.setText("0");
        numberButton1.setText("1");
        numberButton2.setText("2");
        numberButton3.setText("3");
        numberButton4.setText("4");
        numberButton5.setText("5");
        numberButton6.setText("6");
        numberButton7.setText("7");
        numberButton8.setText("8");
        numberButton9.setText("9");
    }

    private void setEvents() {
        setAttackButtonsEvent();
        setNumberButtonsEvent();
        setHiddenNumberButtonsEvent();
        setBasicButtonsEvent();
    }

    private void setNumberButtonsEvent() {
        NumberButtonListener numberButtonListener = NumberButtonListener.getListener();
        numberButton0.addActionListener(numberButtonListener);
        numberButton1.addActionListener(numberButtonListener);
        numberButton2.addActionListener(numberButtonListener);
        numberButton3.addActionListener(numberButtonListener);
        numberButton4.addActionListener(numberButtonListener);
        numberButton5.addActionListener(numberButtonListener);
        numberButton6.addActionListener(numberButtonListener);
        numberButton7.addActionListener(numberButtonListener);
        numberButton8.addActionListener(numberButtonListener);
        numberButton9.addActionListener(numberButtonListener);
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
        exitButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.CLOSED_OPTION) {
                return;
            } else if (result == JOptionPane.YES_NO_OPTION) {
                System.exit(0);
            } else {
                return;
            }
        });

        clearButton.addActionListener(e -> {
            this.topBoard.setText("");
            this.bottomBoard.setText("");
        });
    }

    public static GameFrame getInstance() {
        if (instance == null) {
            instance = new GameFrame();
        }

        return instance;
    }

    public JTextArea getTopBoard() {
        return this.topBoard;
    }

    public JTextArea getBottomBoard() {
        return this.bottomBoard;
    }

    public List<JButton> getHiddenNumberButtons() {
        return List.of(this.hiddenNumberButton1, this.hiddenNumberButton2, this.hiddenNumberButton3, this.hiddenNumberButton4);
    }

    public List<JButton> getAttackNumberButtons() {
        return List.of(this.attackNumberButton1, this.attackNumberButton2, this.attackNumberButton3, this.attackNumberButton4);
    }

    public static void main(String[] args) {
        new GameFrame();
    }

}
