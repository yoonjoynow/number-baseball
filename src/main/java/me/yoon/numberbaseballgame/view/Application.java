package me.yoon.numberbaseballgame.view;

import me.yoon.numberbaseballgame.game.Computer;
import me.yoon.numberbaseballgame.game.NumberBaseballGame;
import me.yoon.numberbaseballgame.game.Referee;
import me.yoon.numberbaseballgame.game.User;

public class Application {

    public void start() {
        User user = new User();
        Computer computer = new Computer();
        Referee referee = new Referee();
        GameFrame.getInstance();
        NumberBaseballGame game = createGame(user, computer, referee);
        game.startGame();
    }

    public static NumberBaseballGame createGame(User user, Computer computer, Referee referee) {
        NumberBaseballGame baseballGame = NumberBaseballGame.getInstance();
        baseballGame.setMembers(user, computer, referee);
        return baseballGame;
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }
}
