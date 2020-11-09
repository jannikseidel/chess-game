import java.util.List;

public class game {
    // Player[] to keep track of the two players, are they human or computer, color and so on
    // board to have a representation of the board
    // currentTurn to determine which player is next
    // status to determine current gamestate
    // movesPlayed to keep track of all played moves

    //TODO Implement check for Check and Check-mate

    private Player[] players;
    private board board;
    private Player currentTurn;
    private GameStatus status;
    private List<Move> movesPlayed;

    private void initialize (Player p1, Player p2)
    {
        players[0] = p1;
        players[1] = p2;
        board.resetBoard();

        if (p1.playerColor().equals("white"))
        {
            this.currentTurn = p1;
        }
        else
        {
            this.currentTurn = p2;
        }
        movesPlayed.clear();
    }
}
