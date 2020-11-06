public class bishop extends figure{

    public bishop(String color, int player){
        super(color, player);

    }

    @Override
    public boolean canMove(board board, field start, field stop) {
        // 1. is the move sidewards -> stepsize in x direction has to be equal to the stepsize in y direction
        // 2. is no figure in the way?
        if (Math.abs(stop.getCoord().get_y()-start.getCoord().get_y()) == Math.abs(stop.getCoord().get_x() -
                start.getCoord().get_x())) {
            // 4 cases have to be checked for figures in its way:
            // +x +y,
            // +x -y,
            // -x -y,
            // -x +y

            // variable to store boolean value for the emptiness of the path
            boolean emptyPath = true;

            if (stop.getCoord().get_x() - start.getCoord().get_x() > 0 &
                    stop.getCoord().get_y() - start.getCoord().get_y() > 0) {
                // +x +y
                for (int i = 1; i < stop.getCoord().get_x() - start.getCoord().get_x(); i++) {
                    for (int j = 1; j < stop.getCoord().get_y() - start.getCoord().get_y(); j++) {
                        if (i == j) {
                            if (board.boxes[start.getCoord().get_y() + j][start.getCoord().get_x() + i].getFig() == null) {
                                emptyPath = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }

            }
            else if (stop.getCoord().get_x() - start.getCoord().get_x() > 0 &
                    stop.getCoord().get_y() - start.getCoord().get_y() < 0) {
                // +x -y
                for (int i = 1; i < stop.getCoord().get_x() - start.getCoord().get_x(); i++) {
                    for (int j = 1; j < stop.getCoord().get_y() - start.getCoord().get_y(); j++) {
                        if (Math.abs(i) == Math.abs(j)) {
                            if (board.boxes[start.getCoord().get_y() - j][start.getCoord().get_x() + i].getFig() == null) {
                                emptyPath = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
            else if (stop.getCoord().get_x() - start.getCoord().get_x() < 0 &
                    stop.getCoord().get_y() - start.getCoord().get_y() < 0) {
                // -x -y
                for (int i = 1; i < stop.getCoord().get_x() - start.getCoord().get_x(); i++) {
                    for (int j = 1; j < stop.getCoord().get_y() - start.getCoord().get_y(); j++) {
                        if (Math.abs(i) == Math.abs(j)) {
                            if (board.boxes[start.getCoord().get_y() - j][start.getCoord().get_x() - i].getFig() == null) {
                                emptyPath = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
            else if (stop.getCoord().get_x() - start.getCoord().get_x() < 0 &
                    stop.getCoord().get_y() - start.getCoord().get_y() > 0) {
                // -x +y
                for (int i = 1; i < stop.getCoord().get_x() - start.getCoord().get_x(); i++) {
                    for (int j = 1; j < stop.getCoord().get_y() - start.getCoord().get_y(); j++) {
                        if (Math.abs(i) == Math.abs(j)) {
                            if (board.boxes[start.getCoord().get_y() + j][start.getCoord().get_x() - i].getFig() == null) {
                                emptyPath = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }

            // if path is empty check whether stop position is eiter empty or occupied by a figure of opposite color
            if (emptyPath){
                if (board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig() == null){
                    return true;
                }
                else if (!board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig().getColor().equals(
                        board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor())){
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

        return false;
    }
}
