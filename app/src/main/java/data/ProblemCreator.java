package data;

import java.util.ArrayList;

public class ProblemCreator {
    private ArrayList<Problem> problemlist;
    private GameSetting gameSetting;
    private PlaySetting playSetting;
    public ProblemCreator(GameSetting gameSetting, PlaySetting playSetting)
    {
        this.gameSetting = gameSetting;
        this.playSetting = playSetting;
    }

    public ArrayList<Problem> getProblemlist() {
        if(gameSetting.gameMode == GameMode.TimeLimit){
            problemlist = new ArrayList<>(100);
            for(int i =0; i< 100; i++)
            {
                problemlist.add(new Problem(gameSetting.gameArithmetic));
            }
        }
        else if(gameSetting.gameMode == GameMode.Quantity)
        {
            problemlist = new ArrayList<>(playSetting.getQuantity());
        }

        return problemlist;
    }
}
