package me.yoon.numberbaseballgame.game;

import javax.swing.*;
import java.util.List;
import java.util.Random;

public class Referee {

    Judgement judgement = new Judgement();

    // 나머지가 0이면 앞면, 사용자 선공
    // 나멎가 1이면 뒷면, 컴퓨터 선공
    public boolean coinToss() {
        JOptionPane.showMessageDialog(null, "코인 토스 시작!");
        int randomNumber = new Random().nextInt(9);
        return randomNumber % 2 == 0;
    }

    public void callWinner(Player player) {
        String message;
        if (isComputer(player)) {
            message = "당신의 패배 ㅠㅠ";
        } else {
            message = "당신의 승리!!!";
        }

        JOptionPane.showMessageDialog(null, message);
        System.exit(0);
    }

    public int[] judge(Player attacker, Player defender) {
        List<Integer> attackNumbers = attacker.attack();
        List<Integer> hiddenNumbers = defender.getHiddenNumbers();

        int[] result = this.judgement.counting(attackNumbers, hiddenNumbers);
        // 게임 종료 로직
        if (isGameOver(result)) {
            callWinner(attacker);
        }

        if (hasOutCounts(result)) {
            excludeOutNumbers(defender, attackNumbers);
        }

        return result;
    }

    private boolean isGameOver(int[] result) {
        // 승리 조건 : 4 스트라이크
        return result[0] == 4;
    }

    private boolean hasOutCounts(int[] result) {
        return (result[0] + result[1]) == 0;
    }

    private void excludeOutNumbers(Player defender, List<Integer> attackNumbers) {
        String message;
        if (isComputer(defender)) {
            // 아웃된 숫자를 컴퓨터가 추리에 사용하지 않게 하는 로직
            Computer computer = (Computer) defender;
            computer.excludeOutNumbers(attackNumbers);
            message = "컴퓨터가 아웃을 획득했습니다 ㅠㅠ";
        } else {
            // 사용자가 아웃을 획득했으면 뭘 해주어야 하나?
            message = "4 아웃!!! 게임이 이제 유리합니다!!";
        }

        JOptionPane.showMessageDialog(null, message);
    }

    private boolean isComputer(Player target) {
        return target instanceof Computer;
    }

}
