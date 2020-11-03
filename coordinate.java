public class coordinate {

    private int x;
    private int y;

    // two methods to get the values for x  and y and return them
    public int get_x(){
        return this.x;
    }
    public int get_y(){
        return this.y;
    }

    // set the x coordinate to a specific value between 0 and 7
    public void set_x(int i){
        if (i>= 0  & i<= 7){
            this.x = i;
        }
        else
        {
            throw new RuntimeException("x-coordinate has to be in the range of 0-7!");
        }
    }

    // set the y coordinate to a specific value between 0 and 7
    public void set_y(int i){
        if (i>= 0  & i<= 7){
            this.y = i;
        }
        else
        {
            throw new RuntimeException("y-coordinate has to be in the range of 0-7!");
        }
    }
    }
}
