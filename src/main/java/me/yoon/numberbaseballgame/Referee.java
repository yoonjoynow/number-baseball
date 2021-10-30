package me.yoon.numberbaseballgame;

import java.util.List;
import java.util.Random;

public class Referee {

    Judgement judgement = new Judgement();

    // 나머지가 0이면 앞면, 사용자 선공
    // 나멎가 1이면 뒷면, 컴퓨터 선공
    public boolean coinToss() {
        System.out.println("동전 던지기 팅~!");
        int randomNumber = new Random().nextInt(9);
        if (randomNumber % 2 == 0) {
            return true;
        }

        return false;
    }

    public void callWinner(Player player) {
        boolean isComputer = checkComputer(player);
        String winner = "";
        if (isComputer) {
            winner = "컴퓨터";
        } else {
            winner = "당신";
        }

        System.out.println(winner + "의 승리!");
        System.exit(0);
    }

    public int[] judge(Player attacker, Player defender) {
        System.out.println("판정 시작");
        List<Integer> attackNumbers = attacker.attack();
        List<Integer> hiddenNumbers = defender.getHiddenNumbers();

        int[] result = this.judgement.counting(attackNumbers, hiddenNumbers);
        boolean isGameOver = hasWon(result);
        // 게임 종료 로직
        if (isGameOver) {
            callWinner(attacker);
        }

        boolean hasOutCounts = checkOutCount(result);
        if (hasOutCounts) {
            excludeOutNumbers(defender, attackNumbers);
        }

        return result;
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

    // TODO : 이 로직은 Computer로 가야함
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
