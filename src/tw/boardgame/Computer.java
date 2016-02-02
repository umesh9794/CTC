package tw.boardgame;

import tw.boardgame.ships.BattleShip;
import tw.boardgame.ships.CarrierShip;
import tw.boardgame.ships.Patrol;
import tw.boardgame.ships.Submarine;

import java.util.HashSet;
import java.util.Set;

/**
 * Class represents computer as a game player
 * Created by uchaudh on 1/30/2016.
 */
public class Computer {

    BattleShip bs;
    CarrierShip cs;
    Submarine ss;
    Patrol ps;

    Set<String> sinkedShips;
    Set<String> cellsShotByUser;

    /**
     * Computer allocates the cells on board
     */
    public Computer()
    {
        sinkedShips=new HashSet<String>();
        cellsShotByUser =new HashSet<String>();
        (bs=new BattleShip()).allocateSpaceOnBoard();
        (cs =new CarrierShip()).allocateSpaceOnBoard();
        (ss=new Submarine()).allocateSpaceOnBoard();
        (ps=new Patrol()).allocateSpaceOnBoard();
    }

    /**
     * Computer checks for HIT or MISS for a user input
     * @param cell
     * @return
     */
    public String chekForHitOrMiss(String cell)
    {
        String computerReply;
        Board currentBoard = Board.getInstance();

        //If user types "I LOSE", print the current board
        if(cell.equals("I LOSE"))
        {
            StringBuilder builder=new StringBuilder();
            for(String singleCell:cellsShotByUser)
            {
                RowEnum num = RowEnum.valueOf(singleCell.substring(0, 1));
                int row = num.getNumVal();
                int col = Integer.parseInt(singleCell.substring(1, 2))-1;
                currentBoard.board[row][col]= '0';
            }

            for(int i=0;i<10;i++)
            {
                for(int j=0;j<10;j++)
                {
                    builder.append(currentBoard.board[i][j]).append("\t");
                }
                builder.append("\n");
            }

            computerReply=builder.toString();

            return computerReply;
        }
        else {
            cellsShotByUser.add(cell);
            RowEnum num = RowEnum.valueOf(cell.substring(0, 1));
            int row = num.getNumVal();
            int col = Integer.parseInt(cell.substring(1, 2))-1;

            if (currentBoard.board[row][col] == 0) {
                computerReply= "MISS";
            } else {
                computerReply= "HIT";

                String cellString = String.valueOf(row) + String.valueOf(col);

                if (bs.occupiedCellsOnBoard.contains(cellString))
                {
                    bs.occupiedCellsOnBoard.remove(cellString);
                    bs.deAllocateSpaceAfterShot(cellString);
                    if(bs.occupiedCellsOnBoard.size()==0) {
                        computerReply = "SINK";
                        sinkedShips.add(bs.shipName);
                    }
                }
                else if(cs.occupiedCellsOnBoard.contains(cellString))
                {
                    cs.occupiedCellsOnBoard.remove(cellString);
                    cs.deAllocateSpaceAfterShot(cellString);
                    if(cs.occupiedCellsOnBoard.size()==0) {
                        computerReply = "SINK";
                        sinkedShips.add(cs.shipName);
                    }

                }
                else if(ss.occupiedCellsOnBoard.contains(cellString))
                {
                    ss.occupiedCellsOnBoard.remove(cellString);
                    ss.deAllocateSpaceAfterShot(cellString);
                    if(ss.occupiedCellsOnBoard.size()==0) {
                        computerReply = "SINK";
                        sinkedShips.add(ss.shipName);
                    }
                }
                else if(ps.occupiedCellsOnBoard.contains(cellString))
                {
                    ps.occupiedCellsOnBoard.remove(cellString);
                    ps.deAllocateSpaceAfterShot(cellString);
                    if(ps.occupiedCellsOnBoard.size()==0) {
                        computerReply = "SINK";
                        sinkedShips.add(ps.shipName);
                    }
                }

                if(sinkedShips.size()==4)
                    computerReply="YOU WIN";
            }
            return computerReply;
        }
    }
}
