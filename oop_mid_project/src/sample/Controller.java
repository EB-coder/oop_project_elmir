package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Canvas canvas;
    @FXML
    Pane action_pane;

    Random random = new Random();
    int turn = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Rect bg = new Rect(0, 0, 500, 400, Color.rgb(210, 231 , 252), gc);

        for(int i = 0; i < 15; i++){
            Circ cloud = new Circ(-8 + 35 * i, 0, 44, Color.rgb(188, 188 , 188), gc);
        }
        Rect dirt = new Rect(0, 330, 500, 70, Color.rgb(94, 71 , 1), gc);
        Rect clouds = new Rect(0, 0, 500, 30, Color.rgb(188, 188 , 188), gc);
        Rect grass = new Rect(0, 330, 500, 20, Color.rgb(0, 60 , 0), gc);

        Timeline tml = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            snow();
        }));
        tml.setAutoReverse(false);
        tml.setCycleCount(Timeline.INDEFINITE);
        tml.play();
    }

    void snow(){

        int bound = 5;

        if (turn == 1){
            turn += 1;
        }else if(turn == 2){
            bound = 168;
            turn += 1;
        }else{
            bound = 331;
            turn = 1;
        }

        int x = random.nextInt(163) + bound;

        Circle snowflake = new Circle(x, 30, 5);

        snowflake.setFill(Color.WHITE);
        snowflake.setStroke(Color.BLACK);
        snowflake.setStrokeWidth(1.0);

        action_pane.getChildren().add(snowflake);

        int y = random.nextInt(10) + 303;
        TranslateTransition tr = new TranslateTransition(Duration.millis(4200), snowflake);
        tr.setFromY(0);
        tr.setToY(y);
        tr.setCycleCount(1);
        tr.setAutoReverse(false);
        tr.play();
    }
}
