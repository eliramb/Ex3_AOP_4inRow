package Ex3.FourInRow;

public class Position {
    int row;
    int col;

    public Position(int _row, int _col) {
        row=_row;
        col=_col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        var str = "row = "+row +", col = "+col;
        return str;
    }
}
