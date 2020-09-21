package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Paint;
import javafx.scene.control.CheckBox;


public class StartPanel implements EventHandler<ActionEvent> {

    public static final int XSIZE = 600;
    public static final int YSIZE = 500;
    public static final int HSEPY = 110;
    public static Text title = new Text("JMake7");
    public static Label user,color,score,best;
    public static TextField name;
    public static ChoiceBox<String> choiceColor;
    public static CheckBox audio;
    public static Button start,undo,change,help;
    public static Separator hSep = new Separator();
    public static Pane pane;
    public static int scores = 0;
    public static int bestScore = 0;
    public static HBox hBox;
    public static VBox vBox;

    public static Pane startPanel() {
        pane = new Pane();
        pane.setPrefSize(XSIZE,	YSIZE);
        hSep.setPrefWidth(XSIZE);
        hSep.setLayoutY(HSEPY);

        title.setFont(Font.font("Georgia", FontWeight.BOLD,60));
        title.setFill(Paint.valueOf("rgb(178,22,22)"));
        title.setY(50);
        title.setX(190);

        hBox = new HBox(20);
        hBox.setPadding(new Insets(0,20,0,10));
        user = new Label("Nickname :");
        user.setFont(Font.font("Georgia",FontWeight.MEDIUM,16));
        color = new Label("Color :");
        color.setFont(Font.font("Georgia",FontWeight.MEDIUM,16));
        name = new TextField("User");
        name.setFont(Font.font("Georgia",FontWeight.MEDIUM,16));
        choiceColor= new ChoiceBox<>();
        choiceColor.setStyle("-fx-font-size: 14");
        choiceColor.getItems().addAll("ANTIQUEWHITE","DARKGRAY","GREEN","BLACK");
        choiceColor.setValue("ANTIQUEWHITE");
        choiceColor.setPrefWidth(80);
        start = new Button("Start");
        start.setFont(Font.font("Georgia",FontWeight.MEDIUM,16));
        hBox.getChildren().addAll(user,name,color,choiceColor,start);
        hBox.setAlignment(Pos.CENTER);
        hBox.setLayoutX(0);
        hBox.setLayoutY(70);

        vBox = new VBox(60);
        vBox.setPadding(new Insets(20,50,0,0));
        score = new Label("Score :\n"+ scores);
        score.setFont(Font.font("Georgia",FontWeight.MEDIUM,18));
        best = new Label("Best Score :\n"+ bestScore);
        best.setFont(Font.font("Georgia",FontWeight.MEDIUM,18));
        undo = new Button("Undo");
        undo.setFont(Font.font("Georgia",FontWeight.MEDIUM,16));
        change = new Button("Change");
        change.setFont(Font.font("Georgia",FontWeight.MEDIUM,16));
        vBox.setLayoutY(110);
        vBox.setLayoutX(10);
        vBox.getChildren().addAll(score,best,undo,change);

        help = new Button("?");
        help.setLayoutY(20);
        help.setLayoutX(35);

        audio = new CheckBox("Audio ON\n");
        audio.setLayoutX(505);
        audio.setLayoutY(25);
        audio.setSelected(true);

        audio.setOnAction(event -> {
            if (!audio.isSelected()){
                Main.mediaPlayer.pause();
                audio.setText("Audio OFF");
            }else {
                Main.mediaPlayer.play();
                audio.setText("Audio ON");
            }
        }
        );

        choiceColor.setOnAction(event -> {
            pane.setStyle("-fx-background-color: " + choiceColor.getValue());
            if (choiceColor.getValue().equals("BLACK") || choiceColor.getValue().equals("GREEN")) {
                score.setTextFill(Color.WHITE);
                best.setTextFill(Color.WHITE);
                audio.setTextFill(Color.WHITE);
                user.setTextFill(Color.WHITE);
                color.setTextFill(Color.WHITE);
            }
            else{
                score.setTextFill(Color.BLACK);
                best.setTextFill(Color.BLACK);
                audio.setTextFill(Color.BLACK);
                user.setTextFill(Color.BLACK);
                color.setTextFill(Color.BLACK);
            }
        }
        );

        start.setOnAction(event -> {
            if(PlayGround.isEmptyHexagon) {
                PlayGround.randomHexagon();
                MouveHexagon.setHexagon();
            }
        });

        change.setOnAction(event -> {
            if(!PlayGround.isEmptyHexagon) {
                PlayGround.randomHexagon();
                MouveHexagon.setHexagon();
            }
        });

        undo.setOnAction(event -> {
            if(!PlayGround.isEmptyHexagon && !PlayGround.isChanged) {
                PlayGround.previousHexagon();
                MouveHexagon.setHexagon();
            }
        });

        help.setOnAction(event -> HelpPage.HelpPage());

        pane.setStyle("-fx-background-color:"+choiceColor.getValue());
        pane.getChildren().addAll(hSep,hBox,title,vBox,help,audio);

        PlayGround.createPane();

        MouveHexagon.setHexagon();

        return pane;
    }

    @Override
    public void handle(ActionEvent event) {
    }
}