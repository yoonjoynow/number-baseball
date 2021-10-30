package me.yoon.numberbaseballgame;

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
        Player firstAttacker;
        Player laterAttacker;

        boolean isHeads = this.referee.coinToss();
        if (isHeads) {
            System.out.println("(결과 : 앞면) 당신이 선공, 컴퓨터가 후공입니다.");
            firstAttacker = this.user;
            laterAttacker = this.computer;
        } else {
            System.out.println("(결과 : 뒷면) 당신이 후공, 컴퓨터가 선공입니다.");
            firstAttacker =  this.computer;
            laterAttacker = this.user;
        }

        // 각자 히든 넘버 세팅
        setHiddenNumbers(firstAttacker, laterAttacker);

        // 1회부터 9회까지 각 이닝 시작
        startInnings(firstAttacker, laterAttacker);
    }

    private void setHiddenNumbers(Player firstAttacker, Player laterAttacker) {
        firstAttacker.pickHiddenNumbers();
        laterAttacker.pickHiddenNumbers();
    }

    private void startInnings(Player firstAttacker, Player laterAttacker) {
        int inning = 1;
        while (inning < 10) {
            System.out.println("======================");
            System.out.println(inning + "회 초 시작");
            int[] topResult = startTopRound(firstAttacker, laterAttacker);// 이닝 초
            System.out.println(topResult[0] + "스트라이크 " + topResult[1] + "볼");

            System.out.println("----------------------");
            System.out.println(inning + "회 말 시작");
            int[] bottomResult = startBottomRound(laterAttacker, firstAttacker);// 이닝 말
            System.out.println(bottomResult[0] + "스트라이크 " + bottomResult[1] + "볼");
            inning++;
        }

        System.out.println("무승부!");
    }

    private int[] startTopRound(Player attacker, Player defender) {
        return this.referee.judge(attacker, defender);
    }

    private int[] startBottomRound(Player attacker, Player defender) {
        return this.referee.judge(attacker, defender);
    }

}
