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
        StringBuilder winnerName;
        if (isComputer(player)) {
            winnerName = new StringBuilder("컴퓨터");
        } else {
            winnerName = new StringBuilder("당신");
        }

        System.out.println(winnerName + "의 승리!");
        System.exit(0);
    }

    public int[] judge(Player attacker, Player defender) {
        System.out.println("판정 시작");
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

    // TODO : 이 로직은 Computer로 가야함
    private void excludeOutNumbers(Player defender, List<Integer> attackNumbers) {
        if (isComputer(defender)) {
            // 아웃된 숫자를 컴퓨터가 추리에 사용하지 않게 하는 로직
            Computer computer = (Computer) defender;
            computer.excludeOutNumbers(attackNumbers);
            System.out.println("컴퓨터가 아웃을 획득했습니다 ㅠㅠ");
        } else {
            // 사용자가 아웃을 획득했으면 뭘 해주어야 하나?
            System.out.println("아웃 카운트 획득!!!!!");
        }
    }

    private boolean isComputer(Player target) {
        return target instanceof Computer;
    }

}
