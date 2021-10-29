package me.yoon.numberbaseballgame;

import java.util.List;
import java.util.Random;

public class Referee {

    Judgement judgement = new Judgement();

    // 나머지가 0이면 앞면, 사용자 선공
    // 나멎가 1이면 뒷면, 컴퓨터 선공
    public boolean coinToss() {
        int randomNumber = new Random().nextInt(9);
        if (randomNumber % 2 == 0) {
            System.out.println("앞면 입니다. \n 사용자 선공입니다.");
            return true;
        }

        System.out.println("뒷면입니다. \n 컴퓨터 선공입니다.");
        return false;
    }

    public void judge(Player attacker, Player defender) {
        List<Integer> attackNumbers = attacker.pickAttackNumbers();
        List<Integer> hiddenNumbers = defender.getHiddenNumbers();

        int[] result = this.judgement.counting(attackNumbers, hiddenNumbers);
        boolean isGameOver = hasWon(result);
        if (isGameOver) {
            // 게임 종료 로직

        }

        boolean hasOutCounts = checkOutCount(result);
        if (hasOutCounts) {
            excludeOutNumbers(defender, attackNumbers);
        }
    }

    private boolean hasWon(int[] result) {
        // 승리 조건 : 4 스트라이크
        if (result[0] == 4) {
            return true;
        }

        return false;
    }

    private boolean checkOutCount(int[] result) {
        if (result[0] == 1 && result[1] == 1) {
            return true;
        }

        return false;
    }

    private void excludeOutNumbers(Player defender, List<Integer> attackNumbers) {
        boolean isComputer = checkComputer(defender);
        if (isComputer) {
            // 아웃된 숫자를 컴퓨터가 추리에 사용하지 않게 하는 로직
            Computer computer = (Computer) defender;
            computer.excludeOutNumbers(attackNumbers);
        } else {
            // 사용자가 아웃을 획득했으면 뭘 해주어야 하나?
            System.out.println("아웃 카운트 획득!!!!!");
        }
    }

    private boolean checkComputer(Player target) {
        return target instanceof Computer;
    }

}
