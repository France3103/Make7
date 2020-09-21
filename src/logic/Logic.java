package logic;

import view.IView;


public class Logic implements ILogic{

    private  IView view;

    public void setView(IView view){
        this.view=view;
    }

    @Override
    public boolean isOccupied(LogicHexagon hexagon){
        return hexagon.isOccupied();
    }

    public int[] HexXPosition1and5Lines(){
        int[] Xpos = new int[3];

        for(int i=0;i<3;i++)
            Xpos[i]= view.getXEmptyHexPosition(i);

        return Xpos;
    }

    public int[] HexXPosition2and4Lines(){
        int[] Xpos = new int[3];

        for(int i=3;i<7;i++)
            Xpos[i]= view.getXEmptyHexPosition(i);

        return Xpos;
    }

    public int[] HexXPosition3Line(){
        int[] Xpos = new int[3];

        for(int i=7;i<12;i++)
            Xpos[i]= view.getXEmptyHexPosition(i);

        return Xpos;
    }


}
