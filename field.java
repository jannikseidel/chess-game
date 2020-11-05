public class field {
    private coordinate coord;
    private String color;
    private figure fig;

    // Constructor
    public field(int x, int y, figure f,String col){
        this.setCoord(x,y);
        this.setFigure(f);
        this.setColor(col);
    }

    // change figure on field
    public void setFigure (figure f){
        this.fig = f;
    }

    // return Figure on field
    public figure getFig(){
        return this.fig;
    }

    // set x and y coordinate
    public void setCoord(int x, int y){
        try{
            coord.set_x(x);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            coord.set_y(y);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // get coordinate
    public coordinate getCoord(){
        return this.coord;
    }

    // set color of field
    public void setColor(String col){
        this.color = col;
    }
}
