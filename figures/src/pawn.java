public class pawn{
    // class of pawn
    // is able to move forward; initially 1 or 2 fields afterwards one;
    // gets promoted to queen if it reaches end of board;
    // can attack only sidewards one field
    // has attributes:
    //                  color (black or white)
    //                  player
    //                  field coordinates
    //                  initially moved
    //                  beaten
    //                  stepsize_y
    //                  stepsize_xy

    public String color = new String();
    public int field_x = 0;
    public int field_y = 0;
    public int player = 0;
    private boolean init_moved = false;
    public boolean beaten = false;
    public int allowed_stepsize_y = 0;
    public int allowed_stepsize_plusxy = 0;
    public int allowed_stepsize_minusxy = 0;

    public void update_coordinates(int stepsize_x, int stepsize_y){
        // to guarantee that with every move done the status of initially movement is set to true
        init_moved = true;
        // update the position on the board
        field_x = field_x + stepsize_x;
        field_y = field_y + stepsize_y;
    }

    public void update_allowed_stepsizes(String[][][] board_array) {
        // determine stepsize in y direction
        // cases:
        //          no initial move and no figure in front
        //          """" but figure in front 2 fields away
        //          """" but figure in front 1 field away
        //          initially moved but not in end field with figure in front or not

        if (!init_moved) {
            if (board_array[field_x][field_y][2].equals("1") &
                    board_array[field_x][field_y + 1][3].equals("") & board_array[field_x][field_y + 2][3].equals("")) {
                allowed_stepsize_y = 2;
            } else if (board_array[field_x][field_y][2].equals("1") &
                    board_array[field_x][field_y + 1][3].equals("") & !board_array[field_x][field_y + 2][3].equals("")) {
                allowed_stepsize_y = 1;
            } else if (board_array[field_x][field_y][2].equals("1") &
                    !board_array[field_x][field_y + 1][3].equals("")) {
                allowed_stepsize_y = 0;
            } else if (board_array[field_x][field_y][2].equals("2") &
                    board_array[field_x][field_y - 1][3].equals("") & board_array[field_x][field_y - 2][3].equals("")) {
                allowed_stepsize_y = -2;
            } else if (board_array[field_x][field_y][2].equals("2") &
                    board_array[field_x][field_y - 1][3].equals("") & !board_array[field_x][field_y - 2][3].equals("")) {
                allowed_stepsize_y = -1;
            } else if (board_array[field_x][field_y][2].equals("2") &
                    !board_array[field_x][field_y - 1][3].equals("")) {
                allowed_stepsize_y = 0;
            }
        }
        else if (init_moved) {
            if (board_array[field_x][field_y][2].equals("1") & field_y < 7 & board_array[field_x][field_y + 1][3].equals("")) {
                allowed_stepsize_y = 1;
            } else if (board_array[field_x][field_y][2].equals("1") & field_y < 7 & !board_array[field_x][field_y + 1][3].equals("")) {
                allowed_stepsize_y = 0;
            } else if (board_array[field_x][field_y][2].equals("2") & field_y > 0 & board_array[field_x][field_y - 1][3].equals("")) {
                allowed_stepsize_y = -1;
            } else if (board_array[field_x][field_y][2].equals("2") & field_y > 0 & !board_array[field_x][field_y - 1][3].equals("")) {
                allowed_stepsize_y = 0;
            }
        }

        // determine whether a sidewards move is possible
        //
        // if player 1 and on the x = 0 end of the board
        if (field_x == 0 & board_array[field_x][field_y][2].equals("1")) {
            allowed_stepsize_minusxy = 0;
            if (field_y != 7 & board_array[field_x + 1][field_y + 1][2].equals("2")) {
                allowed_stepsize_plusxy = 1;
            } else if (field_y != 7 & board_array[field_x + 1][field_y + 1][2].equals("1") |
                    field_y != 7 & board_array[field_x + 1][field_y + 1][2].equals("")) {
                allowed_stepsize_plusxy = 0;
            }
            // if field_y == 7 no forward move is possible
            else {
                allowed_stepsize_plusxy = 0;
            }

        }
        // if player 1 and on x = 7 end of board
        else if (field_x == 7 & board_array[field_x][field_y][2].equals("1")) {
            allowed_stepsize_plusxy = 0;
            if (field_y != 7 & board_array[field_x - 1][field_y + 1][2].equals("2")) {
                allowed_stepsize_minusxy = 1;
            } else if (field_y != 7 & board_array[field_x - 1][field_y + 1][2].equals("1") |
                    field_y != 7 & board_array[field_x - 1][field_y + 1][2].equals("")) {
                allowed_stepsize_minusxy = 0;
            }
            // if field_y is 7 no forward move is possible
            else {
                allowed_stepsize_minusxy = 0;
            }
        }
        // if player 2 is on the x = 0 end of the board
        else if (field_x == 0 & board_array[field_x][field_y][2].equals("2")) {
            allowed_stepsize_minusxy = 0;
            if (field_y != 0 & board_array[field_x + 1][field_y - 1][2].equals("1")) {
                allowed_stepsize_plusxy = -1;
            } else if (field_y != 0 & board_array[field_x + 1][field_y - 1][2].equals("2") |
                    field_y != 0 & board_array[field_x + 1][field_y - 1][2].equals("")) {
                allowed_stepsize_plusxy = 0;
            } else {
                allowed_stepsize_plusxy = 0;
            }
        }
        // if player 2 is on the x = 7 end of the board
        else if (field_x == 7 & board_array[field_x][field_y][2].equals("2")) {
            allowed_stepsize_plusxy = 0;
            if (field_y != 0 & board_array[field_x - 1][field_y - 1][2].equals("1")) {
                allowed_stepsize_minusxy = -1;
            } else if (field_y != 0 & board_array[field_x - 1][field_y - 1][2].equals("2") |
                    field_y != 7 & board_array[field_x - 1][field_y - 1][2].equals("")) {
                allowed_stepsize_minusxy = 0;
            }
            // if field_y is 7 no forward move is possible
            else {
                allowed_stepsize_minusxy = 0;
            }
        }
        else {
            // determine the allowed stepsize for player 1 if not on the x ends of field
            if (board_array[field_x][field_y][2].equals("1") && field_y < 7){
                // determine stepsize towards minus x direction
                if (board_array[field_x-1][field_y+1][2].equals("2")){
                    allowed_stepsize_minusxy = 1;
                }
                else {
                    allowed_stepsize_minusxy = 0;
                }

                if (board_array[field_x+1][field_y+1][2].equals("2")){
                    allowed_stepsize_plusxy = 1;
                }
                else {
                    allowed_stepsize_plusxy = 0;
                }
            }
            else if (board_array[field_x][field_y][2].equals("1") && field_y == 7){
                allowed_stepsize_minusxy = 0;
                allowed_stepsize_plusxy = 0;
            }
            // determine the allowed stepsize for player 2 if not on the x ends of field
            if (board_array[field_x][field_y][2].equals("2") && field_y > 0){


                // determine stepsize towards minus x direction
                if (board_array[field_x-1][field_y-1][2].equals("1")){
                    allowed_stepsize_minusxy = -1;
                }
                else {
                    allowed_stepsize_minusxy = 0;
                }

            if (board_array[field_x+1][field_y-1][2].equals("1")){
                allowed_stepsize_plusxy = -1;
            }
            else {
                allowed_stepsize_plusxy = 0;
            }

            }
            else if (board_array[field_x][field_y][2].equals("2") && field_y == 0){
                allowed_stepsize_minusxy = 0;
                allowed_stepsize_plusxy = 0;
            }
        }


    }




}