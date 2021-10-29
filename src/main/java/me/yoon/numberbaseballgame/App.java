package me.yoon.numberbaseballgame;

public class App {

    public static void main(String[] args) {

        User user = new User();
        Computer computer = new Computer();
        Referee referee = new Referee();
        NumberBaseballGame game = new NumberBaseballGame(user, computer, referee);
        game.startGame();
    }
}
