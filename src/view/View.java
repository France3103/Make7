package view;

import logic.ILogic;

public class View implements IView{

    private ILogic logic;

    public void setLogic(ILogic logic) {
        this.logic = logic;
    }

    @Override
    public int getXEmptyHexPosition(int i){
        return PlayGround.xEmptyHexPosition[i];
    }

    @Override
    public int[] getYEmptyHexPosition(){
        return PlayGround.yEmptyHexPosition;
    }

}