public class knight extends figure{

    public knight(String color, int player){
        super(color, player);
    }

    @Override
    public boolean canMove(board board, field start, field stop) {

        if (board.boxes[stop.getCoord().get_y()][stop.getCoord().get_x()].getFig().getColor().equals(this.getColor()))
        {
            return false;
        }

        int x = Math.abs(start.getCoord().get_x() - stop.getCoord().get_x());
        int y = Math.abs(start.getCoord().get_y()-stop.getCoord().get_y());
        return x * y == 2;
    }
}
}
