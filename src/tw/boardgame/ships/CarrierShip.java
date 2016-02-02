package tw.boardgame.ships;

import tw.boardgame.Board;
import tw.boardgame.Interface.IShip;

import java.util.List;

/**
 * Class represents carrier ship
 * Created by uchaudh on 1/30/2016.
 */
public class CarrierShip implements IShip {

    public String shipName="";
    public List<String> occupiedCellsOnBoard;

    public CarrierShip()
    {
        shipName="CarrierShip";
    }

    @Override
    public void allocateSpaceOnBoard() {

        Board currentBoard= Board.getInstance();
        occupiedCellsOnBoard=currentBoard.allocateCellsToShips(5,"horizontal");

    }

    @Override
    public void deAllocateSpaceAfterShot(String cell) {

        Board currentBoard= Board.getInstance();
        int row = Integer.parseInt(cell.substring(0, 1));
        int col = Integer.parseInt(cell.substring(1, 2));

        currentBoard.board[row][col]=0;

    }
}
