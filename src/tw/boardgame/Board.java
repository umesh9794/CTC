package tw.boardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Single Class Board
 * Created by uchaudh on 1/30/2016.
 */
public class Board {

    //Can Be extended to have variable dimensions of board
    private static Board singletonBoard = new Board(10,10);
    private static int rowToAllocate=0;
    public int[][] board =new int[10][10];

    /**
     * Private constructor which initializes the board with 0
     */
    private Board(final int rows,final int columns)
    {

    }

    /**
     * Returns singleton instance for Board
     * @return
     */
    public static Board getInstance()
    {
        return singletonBoard;
    }

    /**
     * Allocate cells for ships
     * @param totalPlaces
     * @param position
     * @return
     */
    public List<String> allocateCellsToShips(final int totalPlaces, final String position)
    {

        List<String> cells= new ArrayList<String>();

        //TODO Allocate slots randomly, currently the allocation is static
//        Random rnd=new Random();//
//        int random = rnd.nextInt(10)+1;//
//        if(random+totalPlaces <10)

        boolean shipPlaced=true;
        while(shipPlaced) {
            for (int i = 0; i < totalPlaces; i++) {
                if (board[rowToAllocate][i] == 0) {
                    board[rowToAllocate][i] = 1;
                    cells.add(String.valueOf(rowToAllocate)+ String.valueOf(i));
                } else {
                    shipPlaced=false;
                    break;
                }
                shipPlaced=true;
            }
        }

        rowToAllocate=rowToAllocate+2;
        return cells;
    }


}
