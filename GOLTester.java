package lab3;

import org.junit.Test;

import static org.junit.Assert.*;

public class GOLTester extends GameOfLife{


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //Test case for  Torus Game of life oneStep

    //Testing if one step properly uses neighbors and assign values
    //nothing should change since all alive cells stay alive
    @Test
    public void oneStepT1(){
        int[][] expect = {{1,0,1},{0,0,0},{1,0,1}};
        int[][] test = {{1,0,1},{0,0,0},{1,0,1}};
        TorusGameOfLife tgol = new TorusGameOfLife(test);
        tgol.oneStep();
        assertArrayEquals(expect, tgol.getBoard());
    }

    //Testing if oneStep "kills" cells due to overpopulation
    @Test
    public void oneStepT2(){
        int[][] expect = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] test = {{1,0,1},{0,1,0},{1,0,1}};
        TorusGameOfLife tgol = new TorusGameOfLife(test);
        tgol.oneStep();
        assertArrayEquals(expect, tgol.getBoard());
    }

    //Testing if oneStep doesn't overlap elements and count neighbors twice
    @Test
    public void oneStepT3(){
        int[][] expect = {{0,0},{0,0}};
        int[][] test = {{1,0},{0,1}} ;
        TorusGameOfLife tgol = new TorusGameOfLife(test);
        tgol.oneStep();
        assertArrayEquals(expect, tgol.getBoard());

     // Testing if oneStep assigns values correctly when wrapping around board
    }@Test
    public void oneStepT4(){
        int[][] expect = {{0,1,1,1,0},{0,0,1,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,1,1,1,0}};
        int[][] test = {{0,1,1,1,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,1,0,0}};
        TorusGameOfLife tgol = new TorusGameOfLife(test);
        tgol.oneStep();
        assertArrayEquals(expect, tgol.getBoard());
    }

    //Testing with a rectangle board
    //Array out of bounds for row
    @Test
    public void oneStepT5(){
        int[][] expect = {{0,0,0,0,0},{0,0,1,0,0},{0,1,1,1,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}}; //6x5
        int[][] test = {{0,0,0,0,0},{0,1,1,1,0},{0,1,0,1,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        TorusGameOfLife tgol = new TorusGameOfLife(test);
        tgol.oneStep();
        assertArrayEquals(expect, tgol.getBoard());
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Test case for Torus Game of life evolution


    //Testing if evolution can call oneStep
    @Test
    public void evolutionT1(){
        int [][] expect = {{0,0,0},{1,1,1},{0,0,0}};
        int [][] test = {{0,1,0},{0,1,0},{0,1,0}};
        TorusGameOfLife tgol = new TorusGameOfLife(test);
        tgol.evolution(1);
        assertArrayEquals(expect, tgol.getBoard());
    }

    //Testing if evolution can properly call oneStep more than once
    @Test
    public void evolutionT2(){
        int [][] expect = {{0,1,0},{0,1,0},{0,1,0}};
        int [][] test = {{0,1,0},{0,1,0},{0,1,0}};
        TorusGameOfLife tgol = new TorusGameOfLife(test);
        tgol.evolution(2);
        assertArrayEquals(expect, tgol.getBoard());
    }

    //checking if oneStep is properly progressing through multiple calls from evolution
    //cells glide across board with evolution(15)
    @Test
    public void evolutionT3(){
        int [][] expect = {{0,0,0,0,0,0,0,0,0,0}
                          ,{0,0,0,0,0,0,0,0,0,0}
                          ,{0,0,0,0,0,0,0,0,0,0}
                          ,{0,0,0,0,0,0,0,0,0,0}
                          ,{0,0,0,0,0,0,0,0,0,0}
                          ,{0,0,0,0,0,0,0,0,0,0}
                          ,{0,0,0,0,0,0,0,1,0,0}
                          ,{0,0,0,0,0,0,0,0,1,0}
                          ,{0,0,0,0,0,0,1,1,1,0}
                          ,{0,0,0,0,0,0,0,0,0,0}};

        int [][] test = {{0,0,0,0,0,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,0,0,0}
                        ,{0,0,1,0,1,0,0,0,0,0}
                        ,{0,0,0,1,1,0,0,0,0,0}
                        ,{0,0,0,1,0,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,0,0,0}};
        TorusGameOfLife tgol = new TorusGameOfLife(test);
        tgol.evolution(15);
        assertArrayEquals(expect, tgol.getBoard());
    }

    //checking when 0 is inputted
    //oneStep is never called so board is left unchanged
    @Test
    public void evolutionT4(){
        int [][] expect = {{1,1,1},{1,1,1},{1,1,1}};
        int [][] test = {{0,0,0},{1,1,1},{0,0,0}};
        TorusGameOfLife tgol = new TorusGameOfLife(test);
        tgol.evolution(0);
        assertArrayEquals(test, tgol.getBoard());
    }

    //checking when a negative integer is inputted
    //loop never stops calling oneStep since n will never reach 0
    @Test
    public void evolutionT5(){
        int [][] expect = {{0,1,0},{0,1,0},{0,1,0}};
        int [][] test = {{0,1,0},{0,1,0},{0,1,0}};
        TorusGameOfLife tgol = new TorusGameOfLife(test);
        tgol.evolution(-1);
        assertArrayEquals(expect, tgol.getBoard());
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //test cases for Torus Game of life neighbors

    //Checking if neighbor checking (without wrapping around) works correctly
    @Test
    public void neighborsT1(){
        int [][] test = {{0,0,0,0,0},{0,0,0,0,0},{0,1,1,1,0},{0,0,0,0,0},{0,0,0,0,0}};
        TorusGameOfLife tgol = new TorusGameOfLife(test);
        assertEquals(3,tgol.neighbors(test,1,2));
    }
    //Checking if corner elements wraps around board to check surrounding elements in small array.
    @Test
    public void neighborsT2(){
        int [][] array = {{0,0,0},{1,1,1},{0,0,0}};
        TorusGameOfLife tgol = new TorusGameOfLife(array);
        assertEquals(3,tgol.neighbors(array,0,0));
    }

    //Checking if corner elements wraps around board to check surrounding elements in large array.
    @Test
    public void neighborsT3(){
        int [][] array = {{1,0,0,0,0}
                         ,{0,0,1,0,0}
                         ,{0,0,1,0,0}
                         ,{0,1,0,1,0}
                         ,{1,0,0,0,0}};
        TorusGameOfLife tgol = new TorusGameOfLife(array);
        assertEquals(2,tgol.neighbors(array,0,array.length-1));
    }

    //checking an element that has neighbors on all sides
    @Test
    public void neighborsT4(){
        int [][] array = {{1,1,1},{1,0,1},{1,1,1}};
        TorusGameOfLife tgol = new TorusGameOfLife(array);
        assertEquals(8,tgol.neighbors(array,1,1));
    }

    //checking with a rectangle board
    @Test
    public void neighborsT5(){
        int [][] array = {{1,1,1},{0,0,0},{0,0,0},{0,0,0}};
        TorusGameOfLife tgol = new TorusGameOfLife(array);
        assertEquals(3,tgol.neighbors(array,3,2));
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    //Test case for Game of life oneStep

    @Test
    public void oneStep1(){
        int[][] expect = {{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}};
        int[][] test = {{0,0,0,0,0},{0,0,0,0,0},{0,1,1,1,0},{0,0,0,0,0},{0,0,0,0,0}};
        GameOfLife gol = new GameOfLife(test);
        gol.oneStep();
        assertArrayEquals(expect, gol.getBoard());
    }
    @Test
    public void oneStep2(){
        int[][] expect = {{0,0,0,0,0,0},{0,0,0,1,0,0},{0,1,0,0,1,0},{0,1,0,0,1,0},{0,0,1,0,0,0},{0,0,0,0,0,0}};
        int[][] test = {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,1,1,1,0},{0,1,1,1,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
        GameOfLife gol = new GameOfLife(test);
        gol.oneStep();
        assertArrayEquals(expect, gol.getBoard());
    }
    @Test
    public void oneStep3(){
        int[][] expect = {{0,0,0,0,0,0},{0,1,1,0,0,0},{0,1,0,0,0,0},{0,0,0,0,1,0},{0,0,0,1,1,0},{0,0,0,0,0,0}};
        int[][] test = {{0,0,0,0,0,0},{0,1,1,0,0,0},{0,1,1,0,0,0},{0,0,0,1,1,0},{0,0,0,1,1,0},{0,0,0,0,0,0}};
        GameOfLife gol = new GameOfLife(test);
        gol.oneStep();
        assertArrayEquals(expect, gol.getBoard());
    }@Test
    public void oneStep4(){
        int[][] expect = {{1,0,1},{0,0,0},{1,0,1}};
        int[][] test = {{1,1,1},{1,1,1},{1,1,1}};
        GameOfLife gol = new GameOfLife(test);
        gol.oneStep();
        assertArrayEquals(expect, gol.getBoard());
    }
    @Test
    public void oneStep5(){
        int[][] expect = {{0,0,0,0,0},{0,0,1,0,0},{0,1,1,1,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}}; //6x5
        int[][] test = {{0,0,0,0,0},{0,1,1,1,0},{0,1,0,1,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        GameOfLife gol = new GameOfLife(test);
        gol.oneStep();
        assertArrayEquals(expect, gol.getBoard());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //test cases for Game of life neighbors

    @Test
    public void neighbors1(){
        int [][] array = {{0,0,0,0,0},{0,0,0,0,0},{0,1,1,1,0},{0,0,0,0,0},{0,0,0,0,0}};
        GameOfLife gol = new GameOfLife(array);
        assertEquals(3,gol.neighbors(array,1,2));
    }
    @Test
    public void neighbors2(){
        int [][] array = {{0,1,0},{0,1,0},{0,1,0}};
        GameOfLife gol = new GameOfLife(array);
        assertEquals(3,gol.neighbors(array,1,2));
    }

}
