package view;

import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class HelpPage {

    public static void HelpPage() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        ImageView helpImage = new ImageView(new Image(new File(Main.IMAGE_PATH + "instructions.png").toURI().toString(),StartPanel.XSIZE,StartPanel.YSIZE,true,true));
        Pane pane = new Pane();
        pane.getChildren().add(helpImage);
        Scene scene = new Scene(pane);
        window.setResizable(false);
        window.setTitle("Instructions");
        Main.addIconImage(window);
        window.setScene(scene);
        window.showAndWait();
    }
}

