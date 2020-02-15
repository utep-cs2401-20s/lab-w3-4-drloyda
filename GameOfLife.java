package lab3;

import java.util.Base64;

 class GameOfLife {
     int size;
     int[][]Board;
     int[][]Previous;


     GameOfLife(){} //default constructor

     GameOfLife(int size){ //constructor with board size
        this.size = size;
        Previous = new int [size][size];
        Board = new int [size][size];
    }
     GameOfLife(int[][]array){ //constructor with board
        size = array.length;
        Previous = new int [size][size];
        Board = new int [size][size];

        for(int i = 0;i < Board.length;i++){
            for(int j = 0; j<Board[i].length; j++){
                Previous[i][j] = array[i][j];
                Board[i][j] = array[i][j];
            }
        }

    }

    int[][] getBoard(){
        return this.Board;
    }

    void oneStep(){


        for(int i = 0; i <Previous.length;i++){
            for(int j = 0; j < Previous[i].length;j++){
                if(Previous[i][j] == 1 && (neighbors(Previous,i,j) ==2 || neighbors(Previous,i,j) ==3)){
                    Board[i][j] = 1;
                }else{
                    Board[i][j] = 0;
                }
                if(Previous[i][j] == 0 && neighbors(Previous,i,j) ==3){
                    Board[i][j] = 1;
                }
            }
        }
        for(int i = 0;i < Board.length;i++){
            for(int j = 0; j<Board[i].length; j++){
                Previous[i][j] = Board[i][j];
            }
        }
    }
    void evolution(int steps){
        int n = steps;
        while(n != 0){
            oneStep();
            n--;
        }

    }
    void printBoard(){
        for(int i = 0; i <Board.length; i++){
            for(int j = 0; j < Board[i].length; j++){
                System.out.print(Board[i][j]);
            }
            System.out.println();
        }
    }

    int neighbors(int[][]Board, int row, int col){
        int neighbors = 0;

//         diagonalLeftTop = Board[row-1][col-1];
//         indexUp = Board[row-1][col];
//         diagonalRightTop = Board[row-1][col+1];
//         indexLeft = Board[row][col-1];
//         index = Board[row][col];
//         indexRight = Board[row][col+1];
//         diagonalLeftBottom = Board[row+1][col-1];
//         indexDown = Board[row+1][col];
//         diagonalRightBottom = Board[row+1][col+1];


        if(row == 0 && col == 0){ //checking first element
            if(Board[row+1][col] == 1){ //down
                neighbors++;
            }
            if(Board[row+1][col+1] == 1){ // rightBottom
                neighbors++;
            }
            if(Board[row][col+1] == 1){ //right
                neighbors++;
            }
        }
        if(row == Board.length-1 && col == 0){ //checking bottom left
            if(Board[row-1][col] == 1){ //up
                neighbors++;
            }
            if(Board[row-1][col+1] == 1){ //rightTop
                neighbors++;
            }
            if(Board[row][col+1] == 1){ //right
                neighbors++;
            }
        }
        if(row == 0 && col == Board.length-1){ //checking top right
            if(Board[row+1][col] == 1){ //down
                neighbors++;
            }
            if(Board[row+1][col-1] == 1){ //bottomLeft
                neighbors++;
            }
            if(Board[row][col-1] == 1){ //left
                neighbors++;
            }
        }
        if(row == Board.length-1 && col == Board.length-1){ //checking bottom right
            if(Board[row-1][col] == 1){ //up
                neighbors++;
            }
            if(Board[row-1][col-1] == 1){ //leftTop
                neighbors++;
            }
            if(Board[row][col-1] == 1){ //left
                neighbors++;
            }
        }
        if(row == 0 && col != 0 && col != Board.length-1){ //checking checking top most row
            if(Board[row+1][col] == 1){ //down
                neighbors++;
            }
            if(Board[row+1][col+1] == 1){ //rightBotttom
                neighbors++;
            }
            if(Board[row+1][col-1] == 1){ //bottomLeft
                neighbors++;
            }
            if(Board[row][col+1] == 1){ //right
                neighbors++;
            }
            if(Board[row][col-1] == 1){ //left
                neighbors++;
            }
        }
        if(row == Board.length-1 && col != 0 && col != Board.length-1){ //checking bottom most row
            if(Board[row-1][col] == 1){ //up
                neighbors++;
            }
            if(Board[row-1][col+1] == 1){ //rightTop
                neighbors++;
            }
            if(Board[row-1][col-1] == 1){ //leftTop
                neighbors++;
            }
            if(Board[row][col+1] == 1){ //right
                neighbors++;
            }
            if(Board[row][col-1] == 1){ //left
                neighbors++;
            }
        }
        if(col == 0 && row != 0 && row != Board.length-1){ //checking left most col
            if(Board[row+1][col] == 1){ //down
                neighbors++;
            }
            if(Board[row-1][col] == 1){ //up
                neighbors++;
            }
            if(Board[row+1][col+1] == 1){ //rightBottom
                neighbors++;
            }
            if(Board[row-1][col+1] == 1){ //rightTop
                neighbors++;
            }
            if(Board[row][col+1] == 1){ //right
                neighbors++;
            }
        }
        if(col == Board.length-1 && row != 0 && row != Board.length-1){ //checking right most col
            if(Board[row+1][col] == 1){ //down
                neighbors++;
            }
            if(Board[row-1][col]== 1){ //up
                neighbors++;
            }
            if(Board[row+1][col-1] == 1){ //bottomLeft
                neighbors++;
            }
            if(Board[row-1][col-1] == 1){ //leftTop
                neighbors++;
            }
            if(Board[row][col-1] == 1){ //left
                neighbors++;
            }
        }
        if(row != 0 && row != Board.length-1 && col != 0 && col!= Board.length-1){
            if(Board[row+1][col] == 1){ //down
                neighbors++;
            }
            if(Board[row-1][col]== 1){ //up
                neighbors++;
            }
            if(Board[row+1][col-1] == 1){ //bottomLeft
                neighbors++;
            }
            if(Board[row-1][col-1] == 1){ //leftTop
                neighbors++;
            }
            if(Board[row][col-1] == 1){ //left
                neighbors++;
            }
            if(Board[row][col+1] == 1){ //right
                neighbors++;
            }
            if(Board[row-1][col+1] == 1){ //rightTop
                neighbors++;
            }
            if(Board[row+1][col+1] == 1){ //rightBottom
                neighbors++;
            }
        }
        return neighbors;
    }

}