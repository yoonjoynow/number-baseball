package me.yoon.numberbaseballgame.game;

import java.util.List;

public class Judgement {

    /**
     * 공격숫자 : 공격자가 수비자에게 제시한 숫자
     * 히든넘버 : 각 플레이어가 서로 맞춰야 하는 상대방의 숫자
     * attackNumbers : 공격자의 공격넘버
     * hiddenNumbers : 수비자의 히든넘버
     * 유의 :    사이즈가 2인 배열을 리턴한다
     *          이 때, 인덱스 0번은 스트라이크 카운트, 1는 볼 카운트이며
     *          두 요소가 모두 0이면 아웃이라고 판단한다
     */
    public int[] counting(List<Integer> attackNumbers, List<Integer> hiddenNumbers) {
        int strikeCount = countStrike(attackNumbers, hiddenNumbers);
        int ballCount = countBall(attackNumbers, hiddenNumbers);
        return getRoundResult(strikeCount, ballCount);
    }

    private int[] getRoundResult(int strikeCount, int ballCount) {
        int[] result = new int[2];
        result[0] = strikeCount;
        result[1] = ballCount - strikeCount;
        return result;
    }

    private int countStrike(List<Integer> attackNumbers, List<Integer> hiddenNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < hiddenNumbers.size(); i++) {
            int attackerNumber = attackNumbers.get(i);
            int defenderNumber = hiddenNumbers.get(i);
            if (attackerNumber == defenderNumber) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private int countBall(List<Integer> attackNumbers, List<Integer> hiddenNumbers) {
        int ballCount = 0;
        for (int i = 0; i < hiddenNumbers.size(); i++) {
            int attackerNumber = attackNumbers.get(i);
            if (hasElement(attackerNumber, hiddenNumbers)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    private boolean hasElement(int attackerNumber, List<Integer> hiddenNumbers) {
        return hiddenNumbers.contains(attackerNumber);
    }

}
