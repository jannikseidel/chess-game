public class pawn extends figure{

    public pawn(String color, int player){
        super(color, player);

    }

    @Override
    public boolean canMove(board board, field start, field stop) {
        // 1. Determine if a two step move is possible
        if (Math.abs(start.getCoord().get_y() - stop.getCoord().get_y()) == 2 & !getInitially_moved() & start.getCoord().get_x() == stop.getCoord().get_x()){
            // 1.1 Determine of no figure is in its way
            if (board.boxes[stop.getCoord().get_y()-start.getCoord().get_y()][start.getCoord().get_x()].getFig() == null)
                if (stop.getCoord().get_y()-start.getCoord().get_y() > 0){
                    if (board.boxes[start.getCoord().get_y()+1][start.getCoord().get_x()].getFig() == null & board.boxes[start.getCoord().get_y()][start.getCoord().get_y()].getFig().getColor().equals("white")){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
               else if (stop.getCoord().get_y()-start.getCoord().get_y() < 0 & board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor().equals("black")){
                    if (board.boxes[start.getCoord().get_y()-1][start.getCoord().get_x()].getFig() == null){
                        return true;
                    }else{
                        return false;
                    }
                }
        }
        // 2. Determine if one step mve forward is possible
        else if (Math.abs(start.getCoord().get_y()-stop.getCoord().get_y()) == 1 & start.getCoord().get_x() == stop.getCoord().get_x()){
            if(stop.getCoord().get_y()-start.getCoord().get_y() > 0 & board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor().equals("white")){
                if (board.boxes[start.getCoord().get_y()+1][start.getCoord().get_x()].getFig() == null){
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else if (stop.getCoord().get_y()-start.getCoord().get_y() < 0 & board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor().equals("black"))
            {
                if (board.boxes[start.getCoord().get_y()-1][start.getCoord().get_x()].getFig() == null){
                    return true;
                }
                else
                {
                    return false;
                }
            }

        }
        // 3. Determine if sidewards move is possible
        else if (Math.abs(start.getCoord().get_y()-stop.getCoord().get_y()) == 1 & start.getCoord().get_x() != stop.getCoord().get_x())
        {
            if (Math.abs(start.getCoord().get_x() - stop.getCoord().get_x()) == 1)
            {
                if (board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor().equals("white") & start.getCoord().get_y()-stop.getCoord().get_y() > 0){
                    if (stop.getCoord().get_x()-start.getCoord().get_x() == 1  & board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()+1].getFig().getColor().equals("black"))
                        {
                        return true;
                        }
                    else if (stop.getCoord().get_x()-start.getCoord().get_x() == -1  & board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()-1].getFig().getColor().equals("black"))
                        {
                        return true;
                        }
                    else
                        {
                        return false;
                        }

                    }
                else if (board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor().equals("black") & start.getCoord().get_y()-stop.getCoord().get_y() < 0){
                    if (stop.getCoord().get_x()-start.getCoord().get_x() == 1  & board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()+1].getFig().getColor().equals("white"))
                    {
                        return true;
                    }
                    else if (stop.getCoord().get_x()-start.getCoord().get_x() == -1  & board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()-1].getFig().getColor().equals("white"))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            else
                {
                    return false;
                }
        }
        // all other cases -> return false
        else
            {
            return false;
            }
    return false;
    }
    }
