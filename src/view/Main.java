package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;


public class Main extends Application {

    public static Stage window;
    public static final String IMAGE_PATH = "resource\\image\\";
    public static final String MUSIC_FILE = "resource\\music\\";
    public static Media sound;
    public static MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("Jmake7");
        sound = new Media(new File(Main.MUSIC_FILE + "Sound.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(-1);
        mediaPlayer.play();
        Scene scene = new Scene(StartPanel.startPanel());
        window.setScene(scene);
        window.setResizable(false);
        addIconImage(window);
        window.show();
    }

    public static void addIconImage(Stage primaryStage)
    {
        Image iconImage;
        iconImage = new Image("file:resource/image/iconBlack.png");
        primaryStage.getIcons().add(iconImage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
