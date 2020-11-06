public class king extends figure {
    // call constructor of parent class
    public king(String color, int player){
        super(color, player);
    }

    // override the abstract class of can move
    @Override
    public boolean canMove(board board, field start, field stop) {
        // determine if a move is valid
        if (Math.abs(stop.getCoord().get_x() - start.getCoord().get_x())<= 1 &
                Math.abs(stop.getCoord().get_y() - start.getCoord().get_y())<= 1)
        {
            // check whether stop field is empty or of different color
            if (!board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig().getColor().
                    equals(board.boxes[start.getCoord().get_y()][start.getCoord().get_y()].getFig().getColor()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
        return false;
    }
}
