package data;

import java.io.Serializable;

public class GameSetting implements Serializable {
    GameMode gameMode;
    GameDifficulty gameDifficulty;
    GameArithmetic gameArithmetic;

    public void setGameMode(GameMode mode){ this.gameMode = mode;}
    public void setGameDifficulty(GameDifficulty difficult){this.gameDifficulty=difficult;}
    public void setGameArithmetic(GameArithmetic arithmetic){this.gameArithmetic=arithmetic;}

}
