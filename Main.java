package lab3;

public class Main extends GameOfLife {
    public static void main(String[] args){



        int [][] array = {{0,0,0,0,0},{0,0,0,0,0},{0,1,1,1,0},{0,0,0,0,0},{0,0,0,0,0}};
        GameOfLife test = new GameOfLife(array);


//        for(int i = 0; i <array.length; i++){
//            for(int j = 0; j < array[i].length; j++){
//                System.out.print(array[i][j]);
//            }
//            System.out.println();
//        }

        test.evolution(1);
        test.printBoard();



        }

}
