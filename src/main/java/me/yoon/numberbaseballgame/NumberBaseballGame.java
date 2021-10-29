package me.yoon.numberbaseballgame;

import java.util.List;

public class NumberBaseballGame {

    private User user;
    private Computer computer;
    private Referee referee;

    public NumberBaseballGame(User user, Computer computer, Referee referee) {
        this.user = user;
        this.computer = computer;
        this.referee = referee;
    }

    // 숫자 야구 게임 시작
    public void startGame() {
        Player firstAttacker = null;
        Player laterAttacker = null;
        boolean isHeads = this.referee.coinToss();
        if (isHeads) {
            System.out.println("당신이 선공, 컴퓨터가 후공입니다.");
            firstAttacker = this.user;
            laterAttacker = this.computer;
        } else {
            System.out.println("당신이 후공, 컴퓨터가 선공입니다.");
            firstAttacker =  this.computer;
            laterAttacker = this.user;
        }

        // 1회부터 9회까지 각 이닝 시작
        startInnings(firstAttacker, laterAttacker);
    }

    private void startInnings(Player firstAttacker, Player laterAttacker) {
        for (int inning = 1; inning <= 9; inning++) {
            startTopRound(firstAttacker, laterAttacker); // 이닝 초
            startBottomRound(laterAttacker, firstAttacker); // 이닝 말
        }
    }

    private void startTopRound(Player attacker, Player defender) {
        this.referee.judge(attacker, defender);
    }

    private void startBottomRound(Player attacker, Player defender) {
        List<Integer> attackNumbers = attacker.pickAttackNumbers();
        List<Integer> hiddenNumbers = defender.getHiddenNumbers();
    }

}
