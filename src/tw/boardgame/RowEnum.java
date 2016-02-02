package tw.boardgame;

/**
 * ENUM for mapping user input to array indices
 * Created by uchaudh on 1/30/2016.
 */
public enum RowEnum {

    A(0),B(1), C(2), D(3), E(4),  F(5), G(6), H(7), I(8), J(9);

    private  int enumvalue;

    /**
     * Constructor for initializing values
     * @param value
     */
    private RowEnum(int value) {
        enumvalue = value;
    }

    /**
     * Get value of specified enum
     * @return
     */
    public int getNumVal() {
        return enumvalue;
    }

}
