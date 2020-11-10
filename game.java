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

    public boolean isEnd()
    {
        return this.getStatus() != GameStatus.ACTIVE;
    }

    public boolean getStatus()
    {
        return this.status;
    }

    public void setStatus(GameStatus status)
    {
        this.status = status;
    }

    // Rewrite for this implementation
    public boolean playerMove(Player player, int startX,
                              int startY, int stopX, int stopY)
    {
        field startBox = board.boxes[startY][startX];
        field endBox = board.boxes[stopY][stopX];
        Move move = new Move(player, startBox, endBox);
        return this.makeMove(move, player);
    }

    private boolean makeMove(Move move, Player player)
    {
        figure sourcePiece = move.getStart().getFig();
        if (sourcePiece == null) {
            return false;
        }

        // valid player
        if (player != currentTurn) {
            return false;
        }

        if (!sourcePiece.getColor().equals(player.playerColor())) {
            return false;
        }

        // valid move?
        if (!sourcePiece.canMove(board, move.getStart(),
                move.getStop())) {
            return false;
        }

        // kill?
        figure destPiece = move.getStart().getFig();
        if (destPiece != null) {
            destPiece.setBeaten(true);
            move.determineFigureKilled(board);
        }

        // castling?
        //    if (sourcePiece != null && sourcePiece instanceof king
        //        && sourcePiece.isCastlingMove()) {
        //    move.setCastlingMove(true);
        // }

        // store the move
        movesPlayed.add(move);

        // move piece from the stat box to end box
        move.getStop().setFigure(move.getStart().getFig());
        move.getStart().setFigure(null);

        if (destPiece != null && destPiece instanceof king) {
            if (player.playerColor().equals("white")) {
                this.setStatus(GameStatus.WHITE_WIN);
            }
            else {
                this.setStatus(GameStatus.BLACK_WIN);
            }
        }

        // set the current turn to the other player
        if (this.currentTurn == players[0]) {
            this.currentTurn = players[1];
        }
        else {
            this.currentTurn = players[0];
        }

        return true;
    }
}

