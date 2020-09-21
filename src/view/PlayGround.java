package view;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayGround {

    public static Hexagon emptyHexagon;

    public static String previousNameHexagon;
    public static String nameHexagon;
    public static AnchorPane updatablePane;
    public static Hexagon hex;
   // public static Hexagon currentHexagon;

    public static int index=0;
    public static int[] xEmptyHexPosition = new int[12];
    public static int[] yEmptyHexPosition = new int[]{0,50,100,150,200,270};

    public final static String emptyHex = Main.IMAGE_PATH+"emptyHexagon.png";
    public final static String hex1 = Main.IMAGE_PATH+"1.png";
    public final static String hex2 = Main.IMAGE_PATH+"2.png";
    public final static String hex3 = Main.IMAGE_PATH+"3.png";

    public static Random random = new Random();

    public static Boolean isEmptyHexagon = true;
    public static Boolean isChanged = false;


    public static void createPane(){
        updatablePane = new AnchorPane();
        updatablePane.maxHeight(200);
        updatablePane.maxWidth(250);
        updatablePane.setPrefSize(200,250);
        updatablePane.setLayoutY(130);
        updatablePane.setLayoutX(230);
        StartPanel.pane.getChildren().add(updatablePane);
        createPlayGround(updatablePane);
        addHexagon(updatablePane, emptyHex);
    }

    public static void createPlayGround(Pane pane){

        for(int i = 0; i<3; i++) {
            emptyHexagon = new Hexagon(100+ 60* i, 0, emptyHex);
            pane.getChildren().add(emptyHexagon);
            xEmptyHexPosition[index] = emptyHexagon.getxPos();
            index++;
        }
        for( int i=0;i<4;i++){
            emptyHexagon = new Hexagon(70+60*i,50,emptyHex);
            pane.getChildren().add(emptyHexagon);
            xEmptyHexPosition[index] = emptyHexagon.getxPos();
            index++;
        }
        for( int i=0;i<5;i++){
            emptyHexagon = new Hexagon(40+60*i,100,emptyHex );
            pane.getChildren().add(emptyHexagon);
            xEmptyHexPosition[index] = emptyHexagon.getxPos();
            index++;
        }
        for( int i=0;i<4;i++){
            emptyHexagon = new Hexagon(70+60*i,150,emptyHex );
            pane.getChildren().add(emptyHexagon);
        }
        for( int i=0;i<3;i++){
            emptyHexagon = new Hexagon(100+ 60* i,200,emptyHex);
            pane.getChildren().add(emptyHexagon);
        }
        for(int j=0; j<12;j++)
            System.out.println(xEmptyHexPosition[j]);
    }

    public static void addHexagon(Pane pane, String s){
        hex= new Hexagon(160, 270, s);
        previousNameHexagon=nameHexagon;
        nameHexagon=s;
        pane.getChildren().add(hex);
        if(!s.equals(emptyHex)) {
            isEmptyHexagon = false;
        }
        //currentHexagon=hex;
    }

    /*public static List<Hexagon> getHexagon(Class<Hexagon> cls){
        ArrayList<Hexagon> someArray = new ArrayList<>();
        for(Node n: updatablePane.getChildren())
            if(cls.isInstance(n)){
                someArray.add((Hexagon) n);
            }
        return someArray;
    }*/

    public static void randomHexagon(){
        int randomNum = random.nextInt(3);
        int randomInt = random.nextInt(2) +1;

        if(randomNum == 0 && nameHexagon.equals(hex1)) {
            if(randomInt == 1) {
                addHexagon(updatablePane, hex2);
            }else {
                addHexagon(updatablePane, hex3);
            }
        }else if(randomNum == 0 && !nameHexagon.equals(hex1)){
            addHexagon(updatablePane,hex1);
        }

        if(randomNum == 1 && nameHexagon.equals(hex2)) {
            if(randomInt == 2) {
                addHexagon(updatablePane, hex1);
            }else {
                addHexagon(updatablePane, hex3);
            }
        }else if(randomNum == 1 && !nameHexagon.equals(hex2)){
            addHexagon(updatablePane,hex2);
        }

        if(randomNum == 2 && nameHexagon.equals(hex3)){
            if(randomInt == 1 ){
                addHexagon(updatablePane,hex2);
            }else {
                addHexagon(updatablePane, hex1);
            }
        }else if(randomNum == 2 && !nameHexagon.equals(hex3)){
            addHexagon(updatablePane,hex3);
        }
        isChanged = false;
        //currentHexagon=hex;
    }

    public static void previousHexagon(){
        addHexagon(updatablePane,previousNameHexagon);
        isChanged = true;
    }
}
