package me.yoon.numberbaseballgame;

import java.util.List;

public class Judgement {

    private int strikeCount;
    private int ballCount;

//    public int[] judge(List<Integer> attacker, List<Integer> defender) {
//        return compute(attacker, defender);
//    }

    /**
     * 공격숫자 : 공격자가 수비자에게 제시한 숫자
     * 히든넘버 : 각 플레이어가 서로 맞춰야 하는 상대방의 숫자
     * @param attackNumbers : 공격자의 공격넘버
     * @param hiddenNumbers : 수비자의 히든넘버
     * @return  사이즈가 2인 배열을 리턴한다
     *          이 때, 인덱스 1번은 스트라이크 카운트, 2는 볼카운트이며
     *          두 요소가 모두 0이면 아웃이라고 판단한다
     */
    public int[] counting(List<Integer> attackNumbers, List<Integer> hiddenNumbers) {
        int[] result = new int[2];

        for (int i = 0; i < hiddenNumbers.size(); i++) {
            int defenderNumber = hiddenNumbers.get(i);
            int attackerNumber = attackNumbers.get(i);
            checkStrike(attackerNumber, defenderNumber);
            checkBall(attackerNumber, hiddenNumbers);
        }

        result[0] = strikeCount;
        result[1] = ballCount - strikeCount;
        return result;
    }

    private void checkStrike(int a, int b) {
        if (a == b) {
            this.strikeCount++;
        }
    }

    private void checkBall(int attackerNumber, List<Integer> defender) {
        if (defender.contains(attackerNumber)) {
            ballCount++;
        }
    }

}
