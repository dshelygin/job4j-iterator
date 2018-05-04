package mThreading.threads;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class PingPong extends Application {
    private static final String JOB4J = "Пинг-понг www.job4j.ru";
    final static Logger logger = Logger.getLogger(PingPong.class);

    @Override
    public void start(Stage stage) {
        int limitX = 300;
        int limitY = 300;
        Group group = new Group();
        Rectangle rect = new Rectangle(50, 100, 10, 10);
        group.getChildren().add(rect);
        Thread flyingRect = new Thread(new RectangleMove(rect));
        flyingRect.start();
        stage.setScene(new Scene(group, limitX, limitY));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.setOnCloseRequest(
            event -> {
                logger.info("interrapted");
                flyingRect.interrupt();
            }
        );
        stage.show();
    }
}