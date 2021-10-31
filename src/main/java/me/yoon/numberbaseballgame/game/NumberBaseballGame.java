package me.yoon.numberbaseballgame.game;

import me.yoon.numberbaseballgame.view.GameFrame;

import javax.swing.*;

public class NumberBaseballGame {

    private static NumberBaseballGame numberBaseballGame;

    private User user;
    private Computer computer;
    private Referee referee;

    private NumberBaseballGame() {
    }

    public static NumberBaseballGame getInstance() {
        if (numberBaseballGame == null) {
            numberBaseballGame = new NumberBaseballGame();
        }

        return numberBaseballGame;
    }

    public void setMembers(User user, Computer computer, Referee referee) {
        this.user = user;
        this.computer = computer;
        this.referee = referee;
    }

    // 숫자 야구 게임 시작
    public void startGame() {
        JOptionPane.showMessageDialog(null, "숫자 야구 게임에 오신 것을 환영합니다.\n" +
                                                                    "A부터 D까지는 본인이 고른 히든버튼이 적히는 공간이며,\n" +
                                                                    "E부터 F까지는 공격숫자가 적히는 공간입니다." +
                                                                    "\n컴퓨터보다 먼저 히든넘버를 모두 맞추면 승리합니다.\n" +
                                                                    "게임은 9회말 까지 진행되며, 그때까지 모두 히든넘버를 맞히지 못하면 무승부입니다.");
        Player firstAttacker;
        Player laterAttacker;

        String message;
        boolean isHeads = this.referee.coinToss();
        if (isHeads) {
            firstAttacker = this.user;
            laterAttacker = this.computer;
            message = "(결과 : 앞면) 당신이 선공, 컴퓨터가 후공입니다.";
        } else {
            firstAttacker =  this.computer;
            laterAttacker = this.user;
            message = "(결과 : 뒷면) 당신이 후공, 컴퓨터가 선공입니다.";
        }

        JOptionPane.showMessageDialog(null, message); // 코인 토스 결과 팝업
        setHiddenNumbers(firstAttacker, laterAttacker); // 각자 히든 넘버 세팅
        startInnings(firstAttacker, laterAttacker); // 1회부터 9회까지 각 이닝 시작
    }

    private void setHiddenNumbers(Player firstAttacker, Player laterAttacker) {
        firstAttacker.pickHiddenNumbers();
        laterAttacker.pickHiddenNumbers();
    }

    private void startInnings(Player firstAttacker, Player laterAttacker) {
        int inning = 1;
        while (inning < 10) {
            startTopRound(firstAttacker, laterAttacker, inning);// 이닝 초
            startBottomRound(laterAttacker, firstAttacker, inning);// 이닝 말
            inning++;
        }

        // 9회까지 승부가 안나면 무승부
        JOptionPane.showMessageDialog(null, "무승부!");
    }

    private void startTopRound(Player attacker, Player defender, int inning) {
        JOptionPane.showMessageDialog(null, inning + "회 초 시작");
        int[] topResult = this.referee.judge(attacker, defender);
        JOptionPane.showMessageDialog(null, topResult[0] + "스트라이크 " + topResult[1] + "볼");
        printMessageAtBottomBoard("컴퓨터가 아래와 같은 결과를 획득했습니다\n " + topResult[0] + "스트라이크 " + topResult[1] + "볼");
    }

    private void startBottomRound(Player attacker, Player defender, int inning) {
        JOptionPane.showMessageDialog(null, inning + "회 말 시작");
        int[] bottomResult = this.referee.judge(attacker, defender);
        JOptionPane.showMessageDialog(null, bottomResult[0] + "스트라이크 " + bottomResult[1] + "볼");
    }

    private void printMessageAtBottomBoard(String message) {
        JTextArea bottomBoard = GameFrame.getInstance().getBottomBoard();
        bottomBoard.setText(message);
    }

}
