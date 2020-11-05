public class board {

    field[][] boxes;
    public board(){
        this.resetBoard();
    }

    public void resetBoard(){

        //initialize white figures
        boxes[0][0] = new field(0,0,new rook("white",0), "black");
        boxes[0][1] = new field(1,0,new knight("white",0), "white");
        boxes[0][2] = new field(2,0,new bishop("white",0), "black");
        boxes[0][3] = new field(3,0,new queen("white",0), "white");
        boxes[0][4] = new field(4,0,new king("white",0), "black");
        boxes[0][5] = new field(5,0,new bishop("white",0), "white");
        boxes[0][6] = new field(6,0,new knight("white",0), "black");
        boxes[0][7] = new field(7,0,new rook("white",0), "white");

        boxes[1][0] = new field(0,1,new pawn("white",0), "white");
        boxes[1][1] = new field(1,1,new pawn("white",0), "black");
        boxes[1][2] = new field(2,1,new pawn("white",0), "white");
        boxes[1][3] = new field(3,1,new pawn("white",0), "black");
        boxes[1][4] = new field(4,1,new pawn("white",0), "white");
        boxes[1][5] = new field(5,1,new pawn("white",0), "black");
        boxes[1][6] = new field(6,1,new pawn("white",0), "white");
        boxes[1][7] = new field(7,1,new pawn("white",0), "black");




        //initialize black figures
        boxes[7][0] = new field(0,7,new rook("black",1), "white");
        boxes[7][1] = new field(1,7,new knight("black",1), "black");
        boxes[7][2] = new field(2,7,new bishop("black",1), "white");
        boxes[7][3] = new field(3,7,new queen("black",1), "black");
        boxes[7][4] = new field(4,7,new king("black",1), "white");
        boxes[7][5] = new field(5,7,new bishop("black",1), "black");
        boxes[7][6] = new field(6,7,new knight("black",1), "white");
        boxes[7][7] = new field(7,7,new rook("black",1), "black");

        boxes[6][0] = new field(0,6,new rook("black",1), "black");
        boxes[6][1] = new field(1,6,new knight("black",1), "white");
        boxes[6][2] = new field(2,6,new bishop("black",1), "black");
        boxes[6][3] = new field(3,6,new queen("black",1), "white");
        boxes[6][4] = new field(4,6,new king("black",1), "black");
        boxes[6][5] = new field(5,6,new bishop("black",1), "white");
        boxes[6][6] = new field(6,6,new knight("black",1), "black");
        boxes[6][7] = new field(7,6,new rook("black",1), "white");

        // initialize remaining fields
        for (int i = 2; i < 6; i++){
            for (int j = 0; j < 8; j++){
                if ((i+j)%2 == 0){
                    boxes[i][j] = new field(j,i,new rook(null,null), "black");
                }
                else
                {
                    boxes[i][j] = new field(j,i,new rook(null,null), "white");
                }


            }
        }
    }
}
