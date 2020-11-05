public class king extends figure {
    // call constructor of parent class
    public king(String color, int player){
        super(color, player);
    }

    // override the abstract class of can move
    @Override
    public boolean canMove(board board, field start, field stop) {
        return false;
    }
}
