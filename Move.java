public class Move {

    // Class representing a chess move
    private Player player;
    private field start;
    private field stop;
    private figure figureMoved;
    private figure figureKilled;

    // Constructor of a Move
    public Move(Player player, field start, field stop){
        this.player = player;
        this.start = start;
        this.stop = stop;
        this.figureMoved = start.getFig();
    }
    // validate move
    public boolean validMove(board board){
        return figureMoved.canMove(board, this.start, this.stop);

    }
    // determine if a figure is killed
    public void determineFigureKilled(board board){
        if (validMove(board) & !this.start.getFig().getColor().equals(this.stop.getFig().getColor()) )
        {
            this.figureKilled = stop.getFig();
        }

    }
    public field getStart()
    {
        return this.start;
    }
    
    public field getStop()
    {
        return this.stop;
    }

}
