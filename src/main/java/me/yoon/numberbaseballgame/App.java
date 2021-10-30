package me.yoon.numberbaseballgame;

public class App {

    private NumberBaseballGame numberBaseballGame;

    public static void main(String[] args) {
        User user = new User();
        Computer computer = new Computer();
        Referee referee = new Referee();
        NumberBaseballGame game = createGame(user, computer, referee);
        game.startGame();
    }

    public static NumberBaseballGame createGame(User user, Computer computer, Referee referee) {
        return NumberBaseballGame.getInstance(user, computer, referee);
    }

}
