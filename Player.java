public abstract class Player {

    public String color;
    public int playerNumber;
    public boolean humanPlayer;

    public boolean isHumanPlayer()
    {
        return this.humanPlayer;
    }
    public String playerColor()
    {
        return this.color;
    }
    public int getPlayerNumber()
    {
        return this.playerNumber;
    }
}
