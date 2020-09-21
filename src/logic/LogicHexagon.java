package logic;

import javafx.scene.shape.Rectangle;

public class LogicHexagon extends Rectangle {

    private int x;
    private int y;
    public int numHexagon;
    private boolean occupied;


    public LogicHexagon(int xPos, int yPos, int numHexagon){
        this.x= xPos;
        this.y= yPos;
        setHeight(16.66667);
        setWidth(18);
        this.numHexagon= numHexagon;
    }

    public int getNumHexagon() {
        return numHexagon;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void LogicGridPane(){
        LogicHexagon hex;
        for(int i=0; i<12;i++){
            if(i<3){

            }
        }
    }

}
