module me.yoon.numberbaseballgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens me.yoon.numberbaseballgame to javafx.fxml;
    exports me.yoon.numberbaseballgame;
    exports me.yoon.numberbaseballgame.ex;
    opens me.yoon.numberbaseballgame.ex to javafx.fxml;
}