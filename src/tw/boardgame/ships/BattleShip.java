package tw.boardgame.ships;

import tw.boardgame.Board;
import tw.boardgame.Interface.IShip;

import java.util.List;

/**
 * Class represents Battle Ship
 * Created by uchaudh on 1/30/2016.
 */
public class BattleShip implements IShip {

    public String shipName="";
    public List<String> occupiedCellsOnBoard;

    public BattleShip()
    {
        shipName="BattleShip";
    }


    @Override
    public void allocateSpaceOnBoard() {
        Board currentBoard= Board.getInstance();
        occupiedCellsOnBoard=currentBoard.allocateCellsToShips(4, "horizontal");
    }

    @Override
    public void deAllocateSpaceAfterShot(String cell) {
        Board currentBoard= Board.getInstance();
        int row = Integer.parseInt(cell.substring(0, 1));
        int col = Integer.parseInt(cell.substring(1, 2));

        currentBoard.board[row][col]=0;

    }
}
