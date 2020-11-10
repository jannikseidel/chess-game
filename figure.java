public abstract class figure {

    /*
    Figures consist of following Atributes
        Color : White or Black
        Player : 1 or 2
        initially_moved : false (init) or true
        beaten: false (init) or true
     */

    private String color;
    private int player;
    private boolean initially_moved = false;
    private boolean beaten = false;

    // constructor for the abstract class
    public figure(String col, int playr) {
        this.color = col;
        this.player = playr;
    }

    // set color of figured(
    public void setColor(String col) {
        this.color = col;
    }
    // set player of figure
    public void setPlayer(int i){
        this.player = i;
    }
    // set initially moved to true
    public void setInitially_moved(boolean moved){
        this.initially_moved = true;
    }
    // set beaten to true
    public void setBeaten(boolean killed){
        this.beaten = true;
    }
    // get color
    public String getColor(){
        return this.color;
    }
    // get player
    public int getPlayer(){
        return this.player;
    }
    // get initially_moved
    public boolean getInitially_moved(){
        return this.initially_moved;
    }
    // get beaten
    public boolean getBeaten(){
        return this.beaten;
    }

    // determine if a figure can move, has to be implemented for each figure type separately
    public abstract  boolean canMove(board board, field start, field stop);
}


