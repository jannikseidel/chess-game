public class rook extends figure{

    public rook(String color, Integer player){
        super(color, player);

    }

    @Override
    public boolean canMove(board board, field start, field stop) {
        // Determine of a valid move was done
        // 1. is it a move in a straight direction?
        // 2. is there a figure in the way?
        boolean emptyPath = true;
        if (start.getCoord().get_x() == stop.getCoord().get_x()) {
            if (start.getCoord().get_x() - stop.getCoord().get_x() > 0) {
                for (int i = start.getCoord().get_x(); i > stop.getCoord().get_x(); i--) {
                    if (board.boxes[start.getCoord().get_y()][i].getFig() == null) {
                        emptyPath = true;
                    } else {
                        emptyPath = false;
                        break;
                    }
                }
                if (emptyPath & board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig() == null) {
                    return true;
                } else if (emptyPath & !board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig().getColor().
                        equals(board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor())) {
                    return true;
                } else {
                    return false;
                }
            } else if (start.getCoord().get_x() - stop.getCoord().get_x() < 0) {
                for (int i = start.getCoord().get_x(); i < stop.getCoord().get_x(); i++) {
                    if (board.boxes[start.getCoord().get_y()][i].getFig() == null) {
                        emptyPath = true;
                    } else {
                        emptyPath = false;
                        break;
                    }
                }
                if (emptyPath & board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig() == null) {
                    return true;
                } else if (emptyPath & !board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig().getColor().
                        equals(board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor())) {
                    return true;
                } else {
                    return false;
                }

            }
        } else if (start.getCoord().get_y() == stop.getCoord().get_y()) {
            if (start.getCoord().get_y() - stop.getCoord().get_y() > 0) {
                for (int i = start.getCoord().get_y(); i > stop.getCoord().get_y(); i--) {
                    if (board.boxes[i][start.getCoord().get_x()].getFig() == null) {
                        emptyPath = true;
                    } else {
                        emptyPath = false;
                        break;
                    }
                }
                if (emptyPath & board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig() == null) {
                    return true;
                } else if (emptyPath & !board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig().getColor().
                        equals(board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor())) {
                    return true;
                } else {
                    return false;
                }
            } else if (start.getCoord().get_y() - stop.getCoord().get_y() < 0) {
                for (int i = start.getCoord().get_y(); i < stop.getCoord().get_y(); i++) {
                    if (board.boxes[i][start.getCoord().get_x()].getFig() == null) {
                        emptyPath = true;
                    } else {
                        emptyPath = false;
                        break;
                    }
                }
                if (emptyPath & board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig() == null) {
                    return true;
                } else if (emptyPath & !board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig().getColor().
                        equals(board.boxes[start.getCoord().get_y()][start.getCoord().get_x()].getFig().getColor())) {
                    return true;
                } else {
                    return false;
                }

            }
            return false;
        }
    return false;
    }
}
