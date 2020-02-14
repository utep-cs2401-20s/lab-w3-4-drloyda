package lab3;


 class TorusGameOfLife extends GameOfLife {
     public static void main(String[] args) {
         int [][] array = {{1,0,1,0},{0,0,0,0},{0,0,0,0},{0,1,1,0}};
         TorusGameOfLife testing = new TorusGameOfLife(array);

         testing.evolution(1);
         testing.printBoard();
     }
     TorusGameOfLife(){} //default constructor

     TorusGameOfLife(int size){ //constructor with board size
         this.size = size;
         Previous = new int [size][size];
         Board = new int [size][size];
     }
     TorusGameOfLife(int[][]array){ //constructor with board
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

    @Override
    int neighbors(int[][]Board,int row, int col){
         int neighbors = 0;
        if(row == 0 && col == 0){ //checking first element
            if(Board[row][(((-1 % size) + size) % size)] == 1 ){ //wrapping right
                neighbors++;
            }
            if(Board[row + 1][(((-1 % size) + size) % size)] == 1 ){ //wrapping right down
                neighbors++;
            }
            if(Board[(((-1 % size) + size) % size)][col] == 1 ){ //wrapping down
                neighbors++;
            }
            if(Board[(((-1 % size) + size) % size)][col + 1] == 1 ){ //wrapping down right
                neighbors++;
            }
            if(Board[Board.length-1][Board.length-1] == 1 ){ //diagonal across
                neighbors++;
            }
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
            if(Board[row][(((-1 % size) + size) % size)] == 1 ){ //wrapping right
                neighbors++;
            }
            if(Board[row - 1][(((-1 % size) + size) % size)] == 1 ){ //wrapping right up
                neighbors++;
            }
            if(Board[row % row][col] == 1 ){ //wrapping upwards
                neighbors++;
            }
            if(Board[row % row][col + 1] == 1 ){ //wrapping upwards right
                neighbors++;
            }
            if(Board[0][Board.length-1] == 1 ){ //diagonal across
                neighbors++;
            }
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
            if(Board[row][col % col] == 1 ){ //wrapping left
                neighbors++;
            }
            if(Board[row + 1][col % col] == 1 ){ //wrapping left down
                neighbors++;
            }
            if(Board[(((-1 % size) + size) % size)][col] == 1 ){ //wrapping down
                neighbors++;
            }
            if(Board[(((-1 % size) + size) % size)][col - 1] == 1 ){ //wrapping down left
                neighbors++;
            }
            if(Board[Board.length-1][0] == 1 ){ //diagonal across
                neighbors++;
            }
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
            if(Board[row][col % col] == 1 ){ //wrapping left
                neighbors++;
            }
            if(Board[row - 1][col % col] == 1 ){ //wrapping left up
                neighbors++;
            }
            if(Board[row % row][col] == 1 ){ //wrapping upwards
                neighbors++;
            }
            if(Board[row % row][col - 1] == 1 ){ //wrapping upwards left
                neighbors++;
            }
            if(Board[0][0] == 1 ){ //diagonal across
                neighbors++;
            }
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
            if(Board[(((-1 % size) + size) % size)][col] == 1 ){ //wrapping down
                neighbors++;
            }
            if(Board[(((-1 % size) + size) % size)][col - 1] == 1 ){ //wrapping down left
                neighbors++;
            }
            if(Board[(((-1 % size) + size) % size)][col + 1] == 1 ){ //wrapping down right
                neighbors++;
            }
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
            if(Board[row % row][col] == 1 ){ //wrapping upwards
                neighbors++;
            }
            if(Board[row % row][col +1] == 1 ){ //wrapping upwards right
                neighbors++;
            }
            if(Board[row % row][col -1] == 1 ){ //wrapping upwards left
                neighbors++;
            }

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

            if(Board[row][(((-1 % size) + size) % size)] == 1 ){ //wrapping right
                neighbors++;
            }
            if(Board[row - 1][(((-1 % size) + size) % size)] == 1 ){ //wrapping right up
                neighbors++;
            }
            if(Board[row + 1][(((-1 % size) + size) % size)] == 1 ){ //wrapping right down
                neighbors++;
            }
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
            if(Board[row][col % col] == 1 ){ //wrapping left
                neighbors++;
            }
            if(Board[row - 1][col % col] == 1 ){ //wrapping left up
                neighbors++;
            }
            if(Board[row + 1][col % col] == 1 ){ //wrapping left down
                neighbors++;
            }
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
