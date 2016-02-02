package tw.boardgame.Interface;

/**
 * Created by uchaudh on 1/30/2016.
 */
public interface IShip {
    void allocateSpaceOnBoard();
    void deAllocateSpaceAfterShot(String cell);
}
