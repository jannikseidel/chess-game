public class queen extends figure{

    public queen(String color, int player){
        super(color, player);
    }

    @Override
    public boolean canMove(board board, field start, field stop) {
        return false;
    }
}
