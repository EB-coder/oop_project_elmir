package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream input = Main.class.getResourceAsStream("project.txt");
            BufferedReader bfr = new BufferedReader(new InputStreamReader(input));
            int read = bfr.read();
            while (read != -1){
                stringBuilder.append((char) read);
                read = bfr.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        primaryStage.setTitle(stringBuilder.toString());
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
